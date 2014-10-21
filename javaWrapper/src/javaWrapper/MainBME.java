package javaWrapper;

import java.util.HashMap;
import java.util.Map;
import inc.bme.api.BMEApi;
import inc.bme.api.InterfaceBMEApi;

public class MainBME {
	
	/** Variables **/
	private final String userName = "";
	private final String password = "";
	private String token = "";
	private String listID = "";
	
	/** bmeServices - variable will be used to make API calls to Benchmark Email
	 *  For now it's set to null. Will be initialized during the login() method below
	**/
	private InterfaceBMEApi bmeServices = null;
	
	/** 
	 * Main - The main method will start the execution of our Java program. For now 
	 * 		  we have some methods running to give you an idea on how to get started! 
	 * 		  If you decide to play around with these files and create your own methods
	 * 		  make sure to have them run in here, have fun! 
	 **/
	
	public static void main(String[] args){
		
		/** Creates an object of MaineBME type
		 *  Note - this alone will not be enough to start making API calls. You must login() first!
		**/
		MainBME bmeObject = new MainBME();
		
		
		bmeObject.login();
		bmeObject.getListID();
		bmeObject.createList();
		bmeObject.addContacts();
		
		}
	
	/**
	* login(): Initializes an xml rpc object and logs into the Benchmark Email account specified.
	* Pre-requisites: Must have a valid Benchmark Email account to log into
	* @Return: N/A
	**/
	public void login(){
		
		/** Initialize an xml rpc object that connects to "http://api.benchmarkemail.com/1.0/" using the BMEApi class **/
		bmeServices = BMEApi.getBMEServices();
		
		try {
			
		/**
		* login(): logs into a Benchmark Email account, the token returned will be stored in the MainBME class variable "token"  
		* Pre-requisites: Must have a valid Benchmark Email account to log into 
		* @param userName: The user name for a Benchmark Email account
		* @param password: The password that belongs to the Benchmark Email username
		* @Return: the API key associated with the specified Benchmark Email account
		**/
		token = bmeServices.login(userName, password);
		
		}
		catch(Exception e){
			
			/** Print out error message and close program if login was unsuccessful**/
			System.out.println("login():" + e.getMessage());
			System.exit(1);
			
		}
		
		/** Display token if login was successful **/
		if(token.length() > 0){
			System.out.println("Welcome! Your token is: " + token);
		}


	}
	
	
	/**
	 * createList(): Creates a new mailing list in your Benchmark Email account
	 * Pre-requisites: Must have a valid API token to pass along as the first parameter
	 * @Return : N/A 
	 */
	public void createList(){
		
		/** The name of the list we want to create **/
		String listName = "My New List";
		
		try{
			
			/** 
			 * listCreate(): Create the list in the Benchmark Email account associated with the token passed in 
			 * @param token: the API token associated to the Benchmark Email account we logged in with
			 * @param listName: The name of the list we are creating. Every list name must have its own unique name (BME does not allow duplicates) 
			 * @Return: The list ID of the newly created list
			 */
			String newListID = bmeServices.listCreate(token, listName);
			
			/** Display ID of newly created list **/
			System.out.println("List has been created successfully! \nNew List ID : " + newListID);
		}
		catch(Exception e){
			
			/** Print out error message **/
			System.out.println("listCreate() ERROR: " + e.getMessage());
		}
	}
		
	
	/**
	 * getListID():  Gets the mailing list ID from the last created mailing list of a Benchmark Email account 
	 * Pre-requisites: Must have a valid API token to pass along as the first parameter 
	 * @Return : The list ID from the last mailing list created on a Benchmark Email account  
	 */
	public String getListID(){
		
		  int pageNumber = 1;
		  int pageSize = 100;
		  
		  /** API call to get an array of lists from your BME account and store as an Object type **/
			/**
			* listGet(): Retrieve a list of mailing lists from the Benchmark Email account
			* Pre-requisites: 
			* - Must have a valid Benchmark Email account to log into 
			* - Must have the token from a Benchmark Email account login to pass in as the first variable 
			* @param token: The token associated with a Benchmark Email account
			* @param filter: if you want to search for a specific list, type in the name here (filters the results by the string you pass in) 
			* @param pageNumber: the page of results that you want to view (for now we pass 1 to view the first page of results) 
			* @param pageSize: the number of mailing lists per page
			* @param orderBy: we have 3 options, either:
			* 		 1) name - alphabetical order
			* 		 2) date - by date created 
			* 		 3) "" empty (which defaults to by date) 
			* @param sortOrder: sort the results either by 3 options:
			* 		 1) asc - for ascending order (oldest mailing list first)
			* 		 2) desc - for descending order (latest created mailing list first)
			* 		 3) "" - defaults to descending order 
			* @Return: An array of mailing lists from the Benchmark Email account  
			**/
		  Object[] Lists = bmeServices.listGet ( token,  "",  pageNumber,  pageSize,  "",  "");
		  
		  /** 
		   * Map the first list record to 'map' variable (i.e. only the first row of the list of mailing lists gets store to map 
		   * 
		   * NOTE: if we wanted the second to last mailing list ID we would change 'Lists[0]' to 'Lists[1]'  
		   *  **/
		  final Map<String, Object> map = (Map<String,Object>) Lists[0];

		  /** Set listID - in this example we are only getting the list ID of the latest mailing list on your account **/
		  listID = (String)map.get("id");
		 
		  
		  return listID;
		}
	
	
	/**
	 * addContacts(): Add contacts to a specific mailing list of a Benchmark Email account  
	 * Pre-requisites: Must have a valid API token to pass along as the first parameter 
	 * @Return : N/A 
	 */
	public void addContacts(){
		
		int contactsAdded = 0;
		String tempListID = "";
		
		/** Create an array of hash map type where we will store the contact information of the contacts to be added **/
		HashMap contacts[] = new HashMap[2];
		contacts[0] = new HashMap();
		contacts[1] = new HashMap();
		
		/** 
		 * Insert details of contacts  
		 * Note: In order to successfully add a contact you must enter an email in the record. Other fields like 'firstname' or 'lastname' are optional 
		 **/
		contacts[0].put("email", "businessman@jpdomain.com");
		contacts[0].put("firstname", "JP");
		contacts[0].put("lastname", "Morgan");
		
		contacts[1].put("email", "sozo@zeppelin.com");
		contacts[1].put("firstname", "Jimmy");
		contacts[1].put("lastname", "Page");
		
		
		/** Retrieve latest mailing list ID **/
		tempListID = getListID();
		
		/**
		 * listAddContacts(): API method that will add our array of contacts to the specified mailing list 
		 * Pre-requisites: 
		 * 	-Must have a valid API token to pass along as the first parameter
		 * 	-Must have at least 1 mailing list in the associated Benchmark Email account to add contacts to
		 * @param token: The API token associated to the Benchmark Email account we logged into 
		 * @param tempListID: The mailing list ID we retrieved using the getListID() method 
		 * @param contacts: Our array of contacts that contain the details of each contact we with to add
		 * @Return : An integer notifying us how many contacts were successfully added 
		 */
		contactsAdded = bmeServices.listAddContacts(token, tempListID, contacts);
				
		/** Check to make sure all our contacts were added successfully **/
		if(contacts.length == contactsAdded){
			System.out.println("All " + contactsAdded + " contact(s) were added successfully!");
		}
		else if(contactsAdded < 1){
			System.out.println("Looks like not all contacts were added!");
			System.out.println("Attempted to add " + contacts.length + " contacts, but 0 contact(s) made it.");
		}
		else if(contacts.length > contactsAdded){
			System.out.println("Looks like not all contacts were added!");
			System.out.println("Attempted to add " + contacts.length + " contacts, but only " + contactsAdded + " contact(s) made it.");
		}

		
	}
	
}

package inc.bme.api;

import java.util.Map;

public interface InterfaceBMEApi {
	/**
	** login() method definition, this  method returns the token that will be used for all the api methods
	**/
	String login(String username, String password);

	/**
	** tokenGet() method definition, this  method returns the token string array
	**/ 	 
	Object[] tokenGet(String userName, String password);	 

	/**
	** tokenAdd() method definition, this  method allows you to add your own custom token
	**/
	boolean tokenAdd(String  userName, String password, String token);

	/**
	** tokenDelete() method definition, this  method allows you to delete your token
	**/	 
	boolean tokenDelete(String userName, String password,String token);	 

	/**
	** clientGetContactInfo() method definition, this  method returns the client setting info
	**/		
	Map<String, String> clientGetContactInfo( String token);

	/**
	** listCreate() method definition, this method creates a new list
	**/

	String listCreate(String token, String listname);

	/**
	** listDelete() method definition, this method deletes the list specified by the listID
	**/

	boolean listDelete(String token, String listID);	 	 

	/**
	** listGet() method definition, this method retreives the array of lists 
	**/

	Object[] listGet(String token, String filter, int pageNumber, int pageSize, String orderBy, String sortOrder);	 

	/**
	** listAddContacts() method definition, this method is used for adding contacts to an existing list 
	**/
	int listAddContacts(String token, String listID, Object[] contacts);

	/**
	** listGetContacts() method definition, this method is used for fetching contact data from an existing list 
	**/	 

	Object[] listGetContacts(String token, String listID, String filter, int pageNumber, int pageSize, String orderBy, String sortOrder); 

	/**
	** listUpdateContactDetails() method definition, this method is used for updating list contact data
	**/	

	Map<Object,Object> listUpdateContactDetails(String token, String listID, String contactID, Map<Object,Object> contactDetails);

	/**
	** listGetContactDetails() method definition, this method is used for obtaining List Details by email
	**/ 

	Map<Object,Object> listGetContactDetails(String token, String listID, String email);	  

	/**
	** listDeleteContacts() method definition, this method is used for deleting contacts in a list.
	**/ 
	boolean listDeleteContacts(String token, String listID, String contacts);	  

	/**
	** listUnsubscribeContacts() method definition, this method is used for unsubscribing contacts from a list.
	**/ 	 
	int listUnsubscribeContacts(String token, String listID, Object[] contacts);

	/**
	** emailCreate() method definition, this method is used for creating a template for mailing.
	**/ 	  

	String emailCreate( String token, Map<Object,Object> emailData );	  

	/**
	** confirmEmailAdd() method definition, this method is used for creating a email address for confirmation.
	**/ 	

	String confirmEmailAdd( String token, String TargetEmailID );

	/**
	** confirmEmailList() method definition, this method is used for getting the list of confirmed email addresses
	**/ 	

	Object[] confirmEmailList( String token );

	/**
	** Schedule Campaign to be sent
	**/        
	boolean emailSchedule(String token, String emailID, String scheduleDate);	

	/**
	** Get list of mail templates created for emailing
	**/    

	Object[] emailGet(String token, String filter, String status, int pageNumber, int pageSize, String orderBy, String sortOrder);

	/**
	** Get details of mail template by ID
	**/   
	Map<Object, Object> emailGetDetail(String token, String emailID);

	/**
	 ** Schedule Campaign to be sent Now
	 **/
	boolean emailSendNow(String token, String emailID);		

	/**
	 ** Unschedule Campaign and return to draft mode
	 **/
	 
	 boolean emailUnSchedule(String token, String emailID);	
	 
	/**
	 ** Send Campaign test mails
	 **/		
	 boolean emailSendTest(String token, String emailID, String testEmail);		 
	 
	/**
	 ** Update campaign template
	 **/		 
	 boolean emailUpdate(String token, Map<Object,Object> emailData);		 

	/**
	** Delete campaign template
	**/

	boolean emailDelete(String token, String emailID);	

	/**
	** Assign email lists to campaign template
	**/
	boolean emailAssignList(String token, String emailID, Object[] lists);	
}

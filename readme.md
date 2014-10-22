##Description

Welcome Java developers! If you're looking to use or learn how to use Benchmark Email's Java wrapper to integrate with our API then you've come to the right place.
The purpose of these files is to help you hit the ground running and start developing using our API quickly and effectively. This project will showcase how to:

- Login to a Benchmark Email account<br>
- Retrieve the ID of a mailing list <br>
- Create a new mailing list<br>
- Prepare an array of contacts to add into a mailing list (using the list ID)<br>

So whether you're new to Java or an experienced software dev, let our example project give you a running start on integrating with Benchmark Email.
Good luck! 

##Prerequisites
In order to be able to run this example project you must have the following:

- Java v1.8 which comes included with JDK8 (Java Development Kit). You can download the JDK8 here:
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- An Eclipse IDE that is compatible with Java v1.8. The Luna or Mars package will work just fine, Kepler and older packages<br>
  would not be compatible. You can download the Eclipse IDE here: <br> 
https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/lunasr1

- No money, our free and paid plans allow you to use our API at no cost. So follow the link and sign up for a free account to receive your API token:<br>
https://ui.benchmarkemail.com/Register

##Setting Up Your Environment for Java 
- Run the JDK installer
- (If using Windows) Change your PATH variable<br>
http://docs.oracle.com/javase/tutorial/essential/environment/paths.html 

- That should be it! You can verify if everything was installed correctly by: <br>
1) Opening up your terminal (command line) <br>
2) Type in "java -version" w/o the quotes <br>
3) Then notice the version number. As long as it is v1.8 or greater then your environment should be all set to go ! <br>
 
 ![javaVersion](http://content.screencast.com/users/bigrp03/folders/Snagit/media/726afb28-6dda-470b-980b-98e1046cd57f/10.10.2014-12.19.png "Java -version")
 
#Configuring the Project for Eclipse 

In order to setup thisproject on Eclipse follow these steps: <br>

- Download the repository<br>
	- Go to https://github.com/Benchmark-Email/bmejavawrapper
	- Click on the "Download ZIP" button located on the right hand side 
- Once the download is finished, extract the zip file (possibly to your desktop for easy access)<br>
- Open Eclipse <br>
- Select a separate (empty) folder as your workspace<br>
- Click on File -> Import... <br>
	- Under the General folder select "Existing Projects into Workspace", then hit Next <br>
	- (1) Make sure that the "Select root directory" option is ticked on the top and click on Browse...<br>
	- Navigate to where you extracted the zip file and highlight the "javaWrapper" folder. Click OK<br>
	- (2) The "javaWrapper" project should appear in the "Projects" section. Make sure javaWrapper is selected<br>
	- (3) Under Options make sure to tick the "Copy projects into Workspace" option<br> 
	- Hit Finish <br>
![importProject](http://content.screencast.com/users/bmeScreens/folders/Snagit/media/d7a4e199-6f4c-4a4e-b9de-7b9aa6b051e2/2014-10-21_14-17-46.png "importProject")

Your Package Explorer should look like this (we will take care of the errors in the next section):<br>

![packageLibs](http://content.screencast.com/users/bigrp03/folders/Snagit/media/716ad428-856c-4afa-90e8-592c2b126e58/10.17.2014-15.22.png "packageWithoutLibs")


<br>
##Importing XML-RPC Libraries
Now the project is imported but we still need to add the xml-rpc libraries (hence the errors).<br>
Never worked with xml-rpc before? No sweat, the files are in the "lib" folder. We just need to import them. <br>

- In Eclipse <br>
	- Click on Project -> Properties <br>
	- Click on "Java Build Path" (will be on the left hand side) <br>
	- Click the "Libraries" tab <br>
	- Click on "Add External JARs..." <br>
	- Navigate to your Workspace folder. Then go to /javaWrapper/lib <br>
	- Highlight all 4 JARs then click the Open button<br>
	<OL>
 <LI>commons-httpclient-3.1<br>
 <LI>ws-commons-util-1.0.2<br>
 <LI>xmlrpc-client-3.1<br>
 <LI>xmlrpc-common-3.1<br>
 </OL>
	- Click OK <br>
	- Eclipse should show the added libraries under "Referenced Libraries" and all the errors should be gone <br>
	![packageExplorer](http://content.screencast.com/users/bigrp03/folders/Snagit/media/3ac88408-9647-4b9b-aa64-2dfb338fe479/10.17.2014-14.00.png "Package Explorer")
<br>
- If you still have an error restart Eclipse by clicking on File -> Restart<br><br> 
Congratulations! You have successfully installed and configured the Benchmark Email Java wrapper! 

#Running the Project

Before we can run the program we need to add our Benchmark Email username and password.<br>
Double click on the "MainBME.java" file under the javaWrapper package in the Package Explorer. <br>
<br>Let's take a look at lines 11 and 12:

![usernamePassword](http://content.screencast.com/users/bigrp03/folders/Snagit/media/d520646e-9ec3-400b-b804-31401a61ea99/10.17.2014-15.29.png "userNamePassword")

<br>In order to successfully connect to a Benchmark Email account you must write in your username and password in the variables 'userName' and 'password'.<br>
<br>The login() method will attempt to login to your Benchmark Email account and set the API token to the 'token' variable. <br> 
Once you have added in your username and password just hit the Run button (1) and click OK (2) . That's all there is to it! 
![runningProject](http://content.screencast.com/users/bmeScreens/folders/Snagit/media/1871faf5-8bd0-4a58-b8c2-7711d86823a9/2014-10-21_14-44-33.png "Running Project") 


#Contact Info 

- Visit our API page to view our other wrappers and documentation:<br>
	http://www.benchmarkemail.com/API/Library


#Licensing 

Copyright (c) 2014 BenchmarkEmail, released under the MIT license

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
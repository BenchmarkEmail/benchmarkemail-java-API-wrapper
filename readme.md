##Description

Welcome Java developers! If you're looking to use or learn how to use Benchmark Email's Java wrapper to integrate with our API then you've come to the right place.
The purpose of these files is to help you hit the ground running and start developing using our API quickly and effectively. This project will showcase how to:

- Login to a Benchmark Email account<br>
- Retrieve the ID of a mailing list <br>
- Create a new mailing list<br>
- Prepare an array of contacts to add into a mailing list (using the list ID)<br>

So whether you're new to Java or an experienced software dev, let our example project give you a running start on integrating with Benchmark Email.
Good luck! 

##Pre Requisites
In order to be able to run this example project you must have the following:

- Java JDK with at least Java v1.8. You can download the JDK here:
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- An Eclipse IDE that is compatible with Java v1.8. You can download the Eclipse IDE here: 
https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/lunasr1

- A Benchmark Email account to connect to. Don't have one? Head on over to our Sign Up page to set up a free account. 
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
 
#Configuring Eclipse for this Project 

In order to setup Eclipse to run the program follow these steps: <br>

- Download files at INSERT LINK TO GITHUB REPOSITORY HERE <br>
- Store in a folder of your preference (possibly in your desktop for easy access)<br>
- Open Eclipse <br>
- Select a separate (empty) folder as your workspace<br>
- Click on File -> Import... <br>
- Under the General folder select "Existing Projects into Workspace", then hit Next <br>
- Make sure that the "Select root directory" option is ticked on the top and click on Browse...<br>
- Navigate to the folder where you stored the example project and click OK<br>
- The "javaWrapper" project should appear in the "Projects" section. Make sure javaWrapper is selected<br>
- Under Options make sure to tick the "Copy projects into Workspace" option<br> 
- Hit Finish <br>

Your Package Explorer should look like this:<br>

![package-Libs](http://content.screencast.com/users/bigrp03/folders/Snagit/media/716ad428-856c-4afa-90e8-592c2b126e58/10.17.2014-15.22.png"packageWithoutLibs")

<br>
Now the files are imported but we still need to add the xml libraries (hence the errors).<br>
These are included in the lib folder, so let's import them. <br>

- In Eclipse <br>
	- Click on Project -> Properties <br>
	- Click on "Java Build Path" (will be on the left hand side) <br>
	- Click the "Libraries" tab <br>
	- Click on "Add External JARs..." <br>
	- Navigate to the lib folder included in the files. If you moved this folder anywhere, navigate to where you moved it <br>
	- Highlight all 4 JARs then click the Open button<br>
	<OL>
 <LI>commons-httpclient-3.1<br>
 <LI>ws-commons-util-1.0.2<br>
 <LI>xmlrpc-client-3.1<br>
 <LI>xmlrpc-common-3.1<br>
 </OL>
	- Click OK <br>
	- Eclipse should show the added libraries under "Referenced Libraries" <br>
	![packageExplorer](http://content.screencast.com/users/bigrp03/folders/Snagit/media/3ac88408-9647-4b9b-aa64-2dfb338fe479/10.17.2014-14.00.png "Package Explorer")
<br>
- The final step is to restart Eclipse so click on File -> Restart<br>
Congratulations! You have successfully installed and configured the Benchmark Email Java wrapper! 

#Running the Project

Now that we have everything set up we have one last thing to cover before we can run our program.<br>
Double click on the "MainBME.java" file under the javaWrapper package in the Package Explorer. <br>
<br>Let's take a look at lines 11 and 12:

![usernamePassword](http://content.screencast.com/users/bigrp03/folders/Snagit/media/d520646e-9ec3-400b-b804-31401a61ea99/10.17.2014-15.29.png "userNamePassword")

<br>In order to successfully connect to a Benchmark Email account you must write in your username and password in the variables 'userName' and 'password'.
These variables will be passed along in the login() method to allow you to login to your Benchmark Email account. 
Once you have added in your username and password just hit the Run button. That's all there is to it!  


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
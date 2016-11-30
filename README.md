# Text Search Engine
Version 1.0 28/11/2016

A command line driven program allows users to search any words in text files in a given directory.

Author: Audchadaporn Lertchanvit (a.lertchanvit@gmail.com)


PREREQUISITE
---------------------------------------------
1. Install Java SE Development Kit 8, please download "Java SE Development Kit 8u111" at http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2. Use Eclipse IDE to build the Java project. The version need to be Eclipse Luna or later. To download the latest version, Eclipse Neon, please go to https://eclipse.org/downloads/
3. The instructions for running a jar file stated here is for Windows machines. 


BUILDING A JAR FILE
---------------------------------------------
Import Java Project:
1. At Eclipse, File -> "Import...".
2. At "Select an import wizard", choose "Existing Projects into Workspace" and click "Next >"
3. Select the archive file, browse SimpleSearch.zip.
4. At "Projects:", check the checkbox next to "SeachEngine (SearchEngine/).
5. Click "Finish", the java project named "SearchEngine" has been imported.

Build and Run The Java Project:
1. Right click on the project in Project Explorer -> "Run As" -> "Run Configurations...".
2. Click "Arguments" tab.
3. Fill a directory path in "Program arguments:". For examle, C:\Users\User\Desktop\TestTxtFiles.
4. Click "Apply" and click "Run".
5. Now, the program is running in the Eclipse console.

Create A Jar File:
1. In Package Explorer, right click on the project name and click "Export...".
2. At "Select an export wizard", search "Runnable JAR file" and choose "Runnable JAR file" and click "Next >".
3. At "Launch configuration:", choose "SearchEngine - SearchEngine".
4. Browse a location for "Export destination" and end with "\SimpleSearch.jar". For example, "C:\Users\User\Desktop\SimpleSearch.jar".
5. At "Library handling", check "Extract required libraries into generated JAR".
6. Click "Finish".
7. Click "OK" to "This operation repacks referenced libraries."
8. There will be a resulting jar file in the destination folder.


RUNNING A JAR FILE
---------------------------------------------
1. Open Windows command prompt and type "cd <directory-path>" and press <ENTER>, <directory-path> is the path of the directory in which the jar file is located. 
***OR***
To directly open command prompt from the folder, in a windows explorer, hold down shift and right click on the folder which includes the jar file. Select "Open command window here".
2. At the appeared command prompt, enter "java -jar SimpleSearch.jar <directory-path>", replace <directory-path> portion by the path of the folder to be searched.
3. Press <ENTER>, the program is started.

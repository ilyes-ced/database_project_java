you need the java extention pack to run this project with vscode

https://open-vsx.org/extension/vscjava/vscode-java-pack

press the play/run button on vscode top bar right side

or place project in the Documents folder and run with:
```bash
# replace <project_folder_name> nad <username>
c:; cd 'c:\Users\<username>\Documents\<project_folder_name>'; & 'C:\Program Files\Java\jdk-21\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\<username>\Documents\<project_folder_name>\bin' 'App'
# if the first doesnt word (i got that error)
c:; cd 'c:\Users\<username>\Documents\<project_folder_name>'; & 'C:\Program Files\Java\jdk-21\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\<username>\Documents\<project_folder_name>\bin' 'App'

c:; cd 'c:\Users\<username>\Documents\<project_folder_name>'; & 'C:\Program Files\Java\jdk-21\bin\java.exe' '@C:\Users\<username>\AppData\Local\Temp\cp_5hjltklq90roliit6y7dhvlfo.argfile' 'App'
```
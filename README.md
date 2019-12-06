# CS426 License Plate Sensor Android App
## How to Run
**If using Simulator:**
> Open AVD Manager and create a Virtual Device. Choose the Nexus 5 for testing. Download the system image Pie in the next window. When installation of the system image is complete, select Pie and your Nexus 5 will now be available to test with.

**If using Android Device:**
> Connect Android Device with USB cable to computer running the Android Studio project. Your Android Device will appear under the 'Running/Available Devices' tab above your files in Android Studio. Click that and proceed by selecting the green play button to run the project on your Android Device. 

## Accessing the Google Firebase Database
> For access to the Firebase Console, email elakic1@binghamton.edu or tballin1@binghamton.edu to be granted autentication. The console holds both the Database and Storage. From the database, the LoadImage child will show the information the picamera obtains and sends to the database, and the Member child will show each key field value and their associated values, including the color, model, name, and plate logged by the user in the Android application. From storage, we are able to receive realtime images taken by the picamera each time a vehicle approaches the PIR motion sensor above the garage. The access token of each image in storage allows us to link that image to its corresponding plate number in Member if the user had inputted it previously as a known vehicle.

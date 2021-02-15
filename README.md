Team Members: Prayash Pant, Ashmita Thapaliya

For our bucket list app, we have added the main activity that uses recycler view to display our bucket list. There are two preloaded bucket list that we added using the arraylist. Then we added a floating action button to the main activity, that will navigate to the add activity layout. For all the activities, we have cleared the default action bar and added a custom toolbar with the activity name and TWU logo. On add activity, we have added a back button as well that will navigate to the main activity page. Add activity has fields for title, description, latitude, longitude and date. Clicking on the select date will give date picker dialog with current date and user will be able to select the date and it will displayed in the textview. There is a submit button as well which will send all the data to the main activity page, i.e the new input will be displayed in the recycler view. We have also made edit activity layout and we will add onClick method to the recyler view to open that activity in coming days. So the summary of the progress we have done:
1. Added recycler view and displayed dummy data. 
2. Floating button to add activity. 
3. User will be able to add new activity and it will be displayed in the main page. 
4. All layout files are made. 


FINAL REPORT: 

We have made all the necessary changes to the app to make it as requested. Starting from the main activity, we have an hard coded array list that shows two dummy data in our recycler view and then it contains floating action button which will navigate users to add item activity which has title, description, latitude, longitude and date fields to enter. Users need to input all the data, if any fields is empty, the app will display toast message to enter all the data and when all data is entered, the bucket list item will be added to the main activity recycler view and will be sorted according to the date(soonest to latest). We compared the date using comparisions.sort method and using .compareTo method by changing string user inputted date to simple date format. Edit item can be opened by clicking on the item and it also has same fields as add item activity. When pressing the item, the edit item activity will have all the same data from the main activity and user can change the data and when they press submit, the updated data will be sent to main activity and will also be sorted by date. The only function not working on our app at this moment is moving the item at the end after check box is checked. We have the check box and user can press it but it is not moving the item to the end. We will be hopefully making it work before the deadline today. 

Lesson Learned: 
We were both overwhelmed when we saw the requirements of this project because we both had only few experience in developing application. We started working on the project asap and made some progress. The main lesson that this project gave us was to manage the workload and work as a team to achieve the completion of the project. We watched countless videos and articles online to be able to complete this app. Another thing to learn was patience and adapting to the code. There were instances when we had so many mistakes in our code and we were having issues getting the app running, we could say that we learned that there will be plenty of mistakes while making application and there is no other way around it. We also learned about the gitlab and the process to push our project to the gitlab using android studio. It was much easier and faster to upload project into gitlab. We can see ourselves using gitlab in the near future to upload and share our projects. We both found it very helpful to be able to see the code uploaded by our professor in the gitlab and it gave us idea on how to start and create a layout of the project. It was a great experience for both of us to develop an andorid app and it will be something we can add to our resume and experience list. 

Major Lesson Learned during this project:

1. Communication and practice are the key for the success of the project. We were both communicating about the changes we made and the changes we wanted to make during creating the app which helped us understand the requirements. Had we not communicated properly, we would not have been able to finish this project. Working as a team of two was perfect and helpful in order to complete the project, we had divided our workload equally and were taking input from each other which allowed us to get rid of any errors and mistakes in the code. 

2. Learn Android Studio and GitLab: Another skills we were able to learn were gitlab and android studio. We had little experience of building apps but this project required a lot of research and hardwork. Working with multiple intent and moving data between them, handling the recycler view adapter, customizing the toolbar, etc were among the skills that we learned. GitLab was also another great addition to our skills and experience. It is a great platform and very easy and helpful to upload projects and share it with our team. 

3. We were little lost at the start and then we read the requirements uploaded by our professor and then we had an overview of what to do and where to start. We learned that requirements should be completely understood before starting on the project. 

4. Another useful lesson that we learned was to use google, stack overflow, gitlub, or any useful resources to be able to check the reason for the error in our code. To our surprise, there were all solutions and explanations to the errors that we encountered during making our app and it was so much easier and faster to be able to solve those errors. 

It was a great experience and we had a fun time creating this app. We look forward to learn more skills and make more apps. 




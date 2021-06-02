<h1>API DOCUMENTATION</h1>

<h3><b>Base URL: http://localhost:8080</b></h3>

<h2>🎄 ADD TOKEN 🎄</h2>
Url: url/fcm/token
Method: POST
Header: application/json
Body: {
        "userId":  Long,
        "token": String
       }
Result:  String(Token added)

------DELETE TOKEN BY UID API-----------------

Url:  url/token/uid             uid--> Long
Method: DELETE
Result:  String(Token Deleted Successfully)

------GETTOKEN BY UID API-----------------

Url:  url/token/uid             uid--> Long
Method: GET
Result: String(Token Deleted Successfully)

------ADD TOPIC API-----------------

Url:  url/addtopic/uid             uid--> Long
Method: GET
Output: String(Topic Added)


------DELETE TOPIC BY UID API-----------------

Url:  url/topic/uid             uid--> Long
Method: DELETE
Output: String(Topic Deleted Successfully)


--------SUBSCRIBE TO TOPIC-----------

Url: url/unsubscribe/uid      uid--> Long
Method: GET 
Result:  {
                   "status": 200,
                 "message": "Topic subscribed"
              }

--------UNSUBSCRIBE TO TOPIC-----------

Url: url/unsubscribe/uid      uid--> Long
Method: GET 
Result:  {
                   "status": 200,
                 "message": "Topic unsubscribed"
              }

-----------SEND NOTIFICATION TO TOKEN-------------

Url: url/notification/token
Method: POST
               Header: application/json
               Body: {
                               "token": String,
                               "title":  String,
                               "message": String
                        }
Result: {
                "status": 200,
                "message": "Notification has been sent."
             }

-----------SEND NOTIFICATION TO TOPIC-------------

Url: url/notification/topic
Method: POST
               Header: application/json
               Body: {
                               "topic": String,
                               "title":  String,
                               "message": String
                        }
Result: {
                "status": 200,
                "message": "Notification has been sent."
             }


------------------ADD STUDENT-----------------------

Url: url/addstudent
Method: POST
Header: application/json
Body: {
            profilePic: ( Byte[]),
            userId:  (Long),
            registrationNo:  String,
            rollNo:  Long,
            name : String,
            department: String,
            batch: String, 
            category: String, 
            fatherName :  String ,
            motherName:   String,
            fatherContactNo:  Long ,
            aadhaarNo:  Long,
            dateOfBirth:  Date,
            bloodGroup:  String ,
            semester: String
         }
Result: {
         profilePic: ( Byte[]),
         userId:  (Long),
         registrationNo:  String,
         rollNo:  Long,
         name : String,
         department: String,
         batch: String, 
         category: String, 
         fatherName :  String ,
         motherName:   String,
         fatherContactNo:  Long ,
         aadhaarNo:  Long,
         dateOfBirth:  Date,
         bloodGroup:  String ,
         semester: String
                        }




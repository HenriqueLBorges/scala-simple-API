# Scala - API

Developer challenge API.

## Elastic Search
After every request the API saves info about the request in the mutant index. Every document in this index contains the structure: `{
        "_index": "mutant",
        "_type": "requests",
        "_id": "1556077132470",
        "_score": 1,
        "_source": {
            "endpoint": "/allWebsites",
            "query_params": {
                "name": "apt"
            },
            "request_ip": "172.18.0.1",
            "response_status": 200,
            "when": "24/4/2019 3:38:52"
        }
    }`

## Endpoints
**all Websites**
----
  Returns a JSON array containing all users' websites.

* **URL**

  /allWebsites

* **Method:**

  `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    "hildegard.org",
    "anastasia.net",
    "ramiro.info",
    "kale.biz",
    "demarco.info",
    "ola.org",
    "elvis.io",
    "jacynthe.com",
    "conrad.com",
    "ambrose.net"
]`
 
* **Error Response:**

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** `Server error.`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/allWebsites",
      dataType: "json",
      type : "GET",
      success : (r) => {
        console.log(r);
      }
    });
  ```

**All users**
----
  Returns a JSON array containing name, email and company name from all users.

* **URL**

  /allUsers

* **Method:**

  `GET`

*  **URL Params**

   **Required:**
 
   `sort=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "name": "Nicholas Runolfsdottir V",
        "email": "Sherwood@rosamond.me",
        "company": "Abernathy Group"
    },
    {
        "name": "Mrs. Dennis Schulist",
        "email": "Karley_Dach@jasper.info",
        "company": "Considine-Lockman"
    },
    {
        "name": "Ervin Howell",
        "email": "Shanna@melissa.tv",
        "company": "Deckow-Crist"
    },
    {
        "name": "Clementina DuBuque",
        "email": "Rey.Padberg@karina.biz",
        "company": "Hoeger LLC"
    },
    {
        "name": "Kurtis Weissnat",
        "email": "Telly.Hoeger@billy.biz",
        "company": "Johns Group"
    },
    {
        "name": "Chelsey Dietrich",
        "email": "Lucio_Hettinger@annie.ca",
        "company": "Keebler LLC"
    },
    {
        "name": "Patricia Lebsack",
        "email": "Julianne.OConner@kory.org",
        "company": "Robel-Corkery"
    },
    {
        "name": "Leanne Graham",
        "email": "Sincere@april.biz",
        "company": "Romaguera-Crona"
    },
    {
        "name": "Clementine Bauch",
        "email": "Nathan@yesenia.net",
        "company": "Romaguera-Jacobson"
    },
    {
        "name": "Glenna Reichert",
        "email": "Chaim_McDermott@dana.io",
        "company": "Yost and Sons"
    }
]`
 
* **Error Response:**

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** `Server error.`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/allUsers?sort=company",
      dataType: "json",
      type : "GET",
      success : (r) => {
        console.log(r);
      }
    });
  ```
* **Notes:**

  <_I decided to leave the option open to order the users array by the other two properties "email" and "company" although if no query param is set or the param value doesn't match one of these options the array will be ordered by the "name" property._>

**Search users by address**
----
  Returns a JSON array containing all users whose "suite" property inside their address contains the value passed in the query string.

* **URL**

  /search/:name

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `name=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "id": 2,
        "name": "Ervin Howell",
        "username": "Antonette",
        "email": "Shanna@melissa.tv",
        "address": {
            "street": "Victor Plains",
            "suite": "Suite 879",
            "city": "Wisokyburgh",
            "zipcode": "90566-7771",
            "geo": {
                "lat": "-43.9509",
                "lng": "-34.4618"
            }
        },
        "phone": "010-692-6593 x09125",
        "website": "anastasia.net",
        "company": {
            "name": "Deckow-Crist",
            "catchPhrase": "Proactive didactic contingency",
            "bs": "synergize scalable supply-chains"
        }
    },
    {
        "id": 3,
        "name": "Clementine Bauch",
        "username": "Samantha",
        "email": "Nathan@yesenia.net",
        "address": {
            "street": "Douglas Extension",
            "suite": "Suite 847",
            "city": "McKenziehaven",
            "zipcode": "59590-4157",
            "geo": {
                "lat": "-68.6102",
                "lng": "-47.0653"
            }
        },
        "phone": "1-463-123-4447",
        "website": "ramiro.info",
        "company": {
            "name": "Romaguera-Jacobson",
            "catchPhrase": "Face to face bifurcated interface",
            "bs": "e-enable strategic applications"
        }
    },
    {
        "id": 5,
        "name": "Chelsey Dietrich",
        "username": "Kamren",
        "email": "Lucio_Hettinger@annie.ca",
        "address": {
            "street": "Skiles Walks",
            "suite": "Suite 351",
            "city": "Roscoeview",
            "zipcode": "33263",
            "geo": {
                "lat": "-31.8129",
                "lng": "62.5342"
            }
        },
        "phone": "(254)954-1289",
        "website": "demarco.info",
        "company": {
            "name": "Keebler LLC",
            "catchPhrase": "User-centric fault-tolerant solution",
            "bs": "revolutionize end-to-end systems"
        }
    },
    {
        "id": 7,
        "name": "Kurtis Weissnat",
        "username": "Elwyn.Skiles",
        "email": "Telly.Hoeger@billy.biz",
        "address": {
            "street": "Rex Trail",
            "suite": "Suite 280",
            "city": "Howemouth",
            "zipcode": "58804-1099",
            "geo": {
                "lat": "24.8918",
                "lng": "21.8984"
            }
        },
        "phone": "210.067.6132",
        "website": "elvis.io",
        "company": {
            "name": "Johns Group",
            "catchPhrase": "Configurable multimedia task-force",
            "bs": "generate enterprise e-tailers"
        }
    },
    {
        "id": 8,
        "name": "Nicholas Runolfsdottir V",
        "username": "Maxime_Nienow",
        "email": "Sherwood@rosamond.me",
        "address": {
            "street": "Ellsworth Summit",
            "suite": "Suite 729",
            "city": "Aliyaview",
            "zipcode": "45169",
            "geo": {
                "lat": "-14.3990",
                "lng": "-120.7677"
            }
        },
        "phone": "586.493.6943 x140",
        "website": "jacynthe.com",
        "company": {
            "name": "Abernathy Group",
            "catchPhrase": "Implemented secondary concept",
            "bs": "e-enable extensible e-tailers"
        }
    },
    {
        "id": 9,
        "name": "Glenna Reichert",
        "username": "Delphine",
        "email": "Chaim_McDermott@dana.io",
        "address": {
            "street": "Dayna Park",
            "suite": "Suite 449",
            "city": "Bartholomebury",
            "zipcode": "76495-3109",
            "geo": {
                "lat": "24.6463",
                "lng": "-168.8889"
            }
        },
        "phone": "(775)976-6794 x41206",
        "website": "conrad.com",
        "company": {
            "name": "Yost and Sons",
            "catchPhrase": "Switchable contextually-based project",
            "bs": "aggregate real-time technologies"
        }
    },
    {
        "id": 10,
        "name": "Clementina DuBuque",
        "username": "Moriah.Stanton",
        "email": "Rey.Padberg@karina.biz",
        "address": {
            "street": "Kattie Turnpike",
            "suite": "Suite 198",
            "city": "Lebsackbury",
            "zipcode": "31428-2261",
            "geo": {
                "lat": "-38.2386",
                "lng": "57.2232"
            }
        },
        "phone": "024-648-3804",
        "website": "ambrose.net",
        "company": {
            "name": "Hoeger LLC",
            "catchPhrase": "Centralized empowering task-force",
            "bs": "target end-to-end models"
        }
    }
]`
 
* **Error Response:**

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** `Server error.`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/search?name=suit",
      dataType: "json",
      type : "GET",
      success : (r) => {
        console.log(r);
      }
    });
  ```

* **Notes:**

  <_The test description asks to search only for the word "suite" inside the address, however address is an object with a "suite" property which in a lot of cases contains the word "suite". So I supposed that the task was to search for the word "suite" inside the property's value. I left the option of searching using other words just in case and I chose to not verify the "name" query param existence, when nothing is passed the API will consider that the user wants to return everything._>

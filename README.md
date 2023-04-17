# keyvault-demo-secrets
Sample project to fetch secrets from azure keyvault and generate Azure active directory token

# Test endpoints

- [Fetching secrets from keyvauly](https://keyvault-demo-secrets.azurewebsites.net/keyvault/v1/secrets/fetch)

- [Generating Azure Active Directory Token](https://keyvault-demo-secrets.azurewebsites.net/keyvault/v1/secrets/token)


# Steps to connect to keyvault and fetch secrets

* Create a Subscription.
* Create a Resource Group.
* Then create a Webapp under your subscription and resource group and add your GIT project to it.
* Create a Keyvault under your subscription and resource group.
* After creating keyvault give permissions to access it to Webapp by going inside your Webapp under settings -> Identity -> Enable System assigned -> permissions -> Azure role assignments -> add a role assignment with scope Keyvault -> and role as Keyvault reader

<img width="1451" alt="Screenshot 2023-04-17 at 8 49 33 AM" src="https://user-images.githubusercontent.com/39440188/232406264-1988def2-c86e-4299-9167-d30cd67c3203.png">

<img width="855" alt="Screenshot 2023-04-17 at 8 54 02 AM" src="https://user-images.githubusercontent.com/39440188/232407460-fcf25a41-37c1-4cfc-9c8c-fe2f74536f67.png">

<img width="1610" alt="Screenshot 2023-04-17 at 8 49 43 AM" src="https://user-images.githubusercontent.com/39440188/232406307-849ffb1b-3df8-4e44-a588-54c7824daac0.png">

* Create a service principal under your active directory or everybody will have a default active directory. You can create service principal by going under Azure Active Directory -> app registrations -> new registraion.
* Once you create a service principal create a secret for it and store the secret value as it will not be revealed later.
* Now Go to your keyvault and enable permissions for webapp and service principal to do that got to Your keyvault -> Access Configuration -> Under Permission model select Vault access policy -> Go to access policies -> create -> Select the template -> I selected Key,Secret and Certificate management -> next -> under principal select your webapp and service principal one by one and save it.

<img width="1507" alt="Screenshot 2023-04-17 at 9 01 57 AM" src="https://user-images.githubusercontent.com/39440188/232409304-4ff77101-38bb-4a93-bd8b-25f3907b79d9.png">

<img width="1299" alt="Screenshot 2023-04-17 at 9 02 14 AM" src="https://user-images.githubusercontent.com/39440188/232409350-0d0c5cf8-8ed2-4fe5-bf2b-80b819a04540.png">

<img width="1059" alt="Screenshot 2023-04-17 at 9 02 25 AM" src="https://user-images.githubusercontent.com/39440188/232409458-9f935a8b-69fc-480b-9e8e-5a9e73c562b2.png">

* Now your webapp has access to your keyvault and you can fetch secrets from it using ManagedIDentities in our case we have provided system identity.


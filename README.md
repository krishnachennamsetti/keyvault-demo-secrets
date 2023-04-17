# keyvault-demo-secrets
Sample project to fetch secrets from azure keyvault and generate Azure active directory token

# Steps to deploy in Azure

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
*


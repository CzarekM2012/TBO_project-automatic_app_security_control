## Objective
The purpose of this project is configuration of CICD process that will ensure security of the app by automatically checking for presence of vulnerabilities.

Tests performed by the process will include:
 - Software Composition Analysis (SCA)
 - Static Application Security Testing (SAST)
 - Dynamic Application Security Testing (DAST)

Testing will be carried out immediately after new changes being pushed out to the remote repository. Results of this process will affect the process of building new image of the app. 

Effectiveness of the CICD process will be checked by intentional introduction of security vulnerabilities in changes. It is supposed to detect flaws in the project and prevent deployment of newly built app image.
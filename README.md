# Getting Started

### Parth-Spring-Kubernetes

I have developed two demo services using springboot with deployment in Kubernetes on local using minikube


Services :

1. demo-backend: API call that returns the current Hello ‘Name’.
‘Name’ should be set from an environment variable. E.g. if $NAME = Parth
so it should print "Hello Parth”



2. demo-frontend: Calls backend and prints the string returned from backend and
appends the date and time. E.g. It should print "01/01/2020 12:00 Hello
Parth", when curl from the frontend service’s pod or if open in the
browser.

#####Prerequisites
Java IDE (I am using SpringSTS
Maven
Docker
Helm
minikubes on the Kubernetes cluster

#####System Configuration at time of test
Ubuntu - Version 18
STS 3+
Maven - Version 3.6.1

#### Below steps i have performed 

Install Minikube on our local machine
Develop an demo application consisting of two Spring Boot services
Set up the application on a one-node cluster using Minikube
Deploy the application using config files


##### MiniKube setup

After completing the installation, we can start Minikube, set VirtualBox as Hypervisor, and configure kubectl to talk to the cluster called minikube:

$> minikube start
$> minikube config set vm-driver virtualbox
$> kubectl config use-context minikube
After that, we can verify that kubectl communicates correctly with our cluster:

$> kubectl cluster-info
The output should look like this:

Kubernetes master is running at https://192.168.99.100:8443
To further debug and diagnose cluster problems, use 'kubectl cluster-info dump'.
At this stage, we'll keep the IP in the response close (192.168.99.100 in our case). We'll later refer to that as NodeIP, which is needed to call resources from outside of the cluster, e. g. from our browser.

Finally, we can inspect the state of our cluster:

$> minikube dashboard
This command opens a site in our default browser, which provides an extensive overview about the state of our cluster.

#### Demo Application
As our cluster is now running and ready for deployment, we need a demo application.

For this purpose, we'll create a simple “Hello world” application, consisting of two Spring Boot services, which we'll call frontend and backend.

The backend provides one REST endpoint on port 8081, returning a String containing its env name and date formate. The frontend is available on port 8082, it will simply call the backend endpoint and return its response.


##### Deployment of backend and frontend using minikube

Before deployment we need to create docker image for both services using below commands

(Please change the path for src code and target as per your system in docker Image)

docker build --tag=demo-backend:latest .

docker build --tag=demo-frontend:latest .


######## backend service deployment steps

We can now trigger the deployment:

$> kubectl create -f backend-deployment.yaml

Let's verify that the deployment was successful:

$> kubectl get deployments

The output looks like this:

NAME           DESIRED   CURRENT   UP-TO-DATE   AVAILABLE   AGE
demo-backend   3         3         3            3           25s

We can also check whether the Service is available:

$> kubectl get services

The output looks like this:

NAME            TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
demo-backend    ClusterIP   10.102.17.114   <none>        8081/TCP         30s

As we can see, the Service is of type ClusterIP, and it doesn't provide an external port in the range 30000-32767


######## Frontend service deployment steps

We can now trigger this deployment the same way:

$> kubectl create -f frontend-deployment.yaml

Let's quickly verify that the deployment was successful and the Service is available:

$> kubectl get deployments

$> kubectl get services

After that, we can finally call the REST endpoint of the frontend application:

$> minikube service demo-frontend

This command will again start our default browser, opening <NodeIP>:<NodePort>, which is http://192.168.99.100:30001


######## For Helm Chart Below Mention Steps Done

1. I have installed the Helm.
2. Then using Helm Create <name> command created the all files and templates.
3. In Value.yml manual ly added app name,chart name and minikube NodePort.
4. then i using Helm installed command deploy the charts and then able to access them on browser.



pipeline {

    environment { 
        registry = "YourDockerhubAccount/YourRepository" 
        registryCredential = 'ahmedhaddad' 
        dockerImage = '' 
    }
    
	agent any

	stages{

			stage('Clean Install'){
				steps{
					bat "mvn clean install -U"
				}				
			}

			stage('Test'){
				steps{
					bat "mvn test"
				}				
			}

			stage('Sonar Analyse'){
				steps{
                    bat "mvn sonar:sonar"
                  }
            }
            
            stage('Nexus Deploy'){
				steps{
                    bat "mvn deploy"
                  }
            }
            
            stage('Cloning our Git') { 
                steps { 
                    git 'https://github.com/DhiaMnasser/TimeSheet-DevOps' 
                  }
            } 
        
            stage('Building our image') { 
                steps { 
                    script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                    }
                } 
            }

           stage('Deploy our image') { 
                steps { 
                    script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
             }
           } 
          
           stage('Cleaning up') { 
                steps { 
                    sh "docker rmi $registry:$BUILD_NUMBER" 
                }
           } 
	} 

}
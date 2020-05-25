pipeline {
	agent {
		docker {
			image 'maven:3.6.1-jdk-8-slim'
			args '-v $HOME/.m2:/root/.m2'
		}
	}
	stages{
		stage("build"){
			steps{
				echo 'Compiling users app..'
				sh 'mvn compile'
        		}
		}
		stage("test"){
			steps{
				echo 'Running Unit Tests ...'
				sh 'mvn clean test'
			}
		}
		stage("package"){
    			steps{
				echo 'Packaging app...'
				sh 'mvn package -DskipTests'
				archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
			}
		}
	}
	post{
      		always{
			echo 'Building multibranch pipeline for users is completed..'
		}
	}
}

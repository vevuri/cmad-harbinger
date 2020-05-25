pipeline {
	agent any
	tools{
		maven 'Maven 3.6.1'
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

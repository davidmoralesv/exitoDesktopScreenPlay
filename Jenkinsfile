import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "davidmoralv@gmail.com";

pipeline{
	agent any
	stages {
		stage('Obtener Fuentes') {
		 	steps {
				 checkout([$class: 'GitSCM', branches: [[name: "master"]],
                                          doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [
                                        [url: "https://github.com/davidmoralesv/exitoDesktopScreenPlay.git"]
                                ]])
			}
		}
		stage('Ejecutar Pruebas') {
			steps {
				script {
					try {
						bat "gradle clean test -Dambiente=${DEPLOY_ENVIRONMENT} --tests \"runners.${DEPLOY_RUNNER}\" aggregate"
						echo 'Test Ejecutados sin Fallo'
						currentBuild.result = 'SUCCESS'
					}
					catch(ex) {
	    				echo 'Test Ejecutados con Fallo'
	    				currentBuild.result ='UNSTABLE'
					}
				}
			}
		}
		stage('Generar Evidencias') {
			steps {
				script {
				    try {
						bat " rename \"${WORKSPACE}\\target\\site\\serenity\" serenity_${timestamp}"
		                echo 'Backup de evidencias realizado con exito'

		                publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity_${timestamp}", reportFiles: 'index.html', reportName: 'Evidencias', reportTitles: 'Evidencias Pruebas'])
						echo 'Reporte Html realizado con exito'
					}
					catch(e) {
						echo 'No se realizó el Backup de evidencias'
			    		publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity", reportFiles: 'index.html', reportName: 'Evidencias', reportTitles: 'Evidencias Pruebas'])
						echo 'Reporte Html realizado con exito'
						currentBuild.result='SUCCESS'
					}
				}
			}
		}
		stage('Notificar') {
			steps {
				script {
					if (currentBuild.result == 'UNSTABLE') currentBuild.result = 'FAILURE'
         			if (currentBuild.result == 'SUCCESS') {
         			    emailext(
							subject: "EXITO - EJECUCION EXITOSA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:MediumSeaGreen;">EJECUCION EXITOSA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					to:"${CORREOS}"
        				)
         			}
        			if (currentBuild.result == 'FAILURE') {
        			    emailext(
          					subject: "EXITO - EJECUCION FALLIDA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:red;">EJECUCION FALLIDA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					to:"${CORREOS}"
        				)
        			}
				}
			}
		}
	}
}

pipeline {
    agent any  // Executa em qualquer agente disponível
    stages {
        // Etapa de construção
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'  // Compila e gera o pacote sem duplicar testes
            }
        }

        // Etapa de testes
        stage('Test') {
            steps {
                sh 'mvn test'  // Executa testes
                junit 'target/surefire-reports/**/*.xml'  // Publica relatórios
            }
        }

        // NOVO: Etapa para análise estática PMD
        stage('PMD Analysis') {
            steps {
                sh 'mvn pmd:check'  // Analisa qualidade do código e falha se houver violações
            }
        }

        // Etapa condicional de deploy com rollback automático
        stage('Deploy to Staging') {
            when {
                branch 'main'  // Só executa no branch main
            }
            steps {
                // Build da imagem Docker
                sh 'docker build -t myapp:${GIT_COMMIT} .'
                // Deploy no Kubernetes
                sh 'kubectl apply -f k8s/deployment.yaml'
                // Verifica se o deploy subiu corretamente dentro do tempo limite
                sh 'kubectl rollout status deployment/myapp --timeout=120s'
            }
            // NOVO: Rollback automático se o deploy falhar
            post {
                failure {
                    echo 'Falha no deploy detectada! Executando rollback no Kubernetes...'
                    sh 'kubectl rollout undo deployment/myapp'
                }
            }
        }
    }

    // Ações pós-build gerais
    post {
        failure {
            // Notificação no Slack em caso de falha
            slackSend channel: '#alerts', message: "Build Failed: ${env.JOB_NAME}"
        }
    }
}

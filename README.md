#Curso de Kotlin Android

Neste curso iremos aprender como fazer um app de Login simples, mas com SharedPreference.

Faça o clone do projeto e apois isso realize os passos descritos abaixo.

1 - Criar a classe SaveSharedPreference, para que seja usada para guardar as preferencias de Login

2 - Após ter craido a classe do SaveSharedPreference, va até a classe MainActivity e estenda a classe SaveSharedPreference
desta forma: 

    private val saveSharedPreference = SaveSharedPreference()

3 - Após isso criaremos a função de clickLogin: 
        
        fun onClick(view: View){
            login(findViewById<TextInputEditText>(R.id.edtUserName).text.toString(),
            findViewById<TextInputEditText>(R.id.edtPassword).text.toString())
        }
        
4 - Após ter criado a função de clickLogin, criaremos a função e logar no aplicativo:

        private fun login(userName: String, password: String) {
                if (userName == "name" && password == "1234"){
                    saveSharedPreference.setLoggedIn(applicationContext, true)
                    startActivity(Intent(this, HomeActivity::class.java))
                    Toast.makeText(this, "Login com Sucesso", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Falha no Login", Toast.LENGTH_LONG).show()
                }
        }
             
5 - Feito isso vamos testar a plicação, estando tudo ok, vamos criar o acesso a home sem precisar digitar 
o usuário e a senha, dentro do onCreate da MainActivity faça este passo:

        if(saveSharedPreference.getLoggedStatus(applicationContext)){
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
        } 
        
        OBS: Não esqueça de criar a classe HomeActivity antes de implementar esse metodo, e declara - la no AndroidManifest.xml assim:
        <activity android:name=".HomeActivity"/>
        
6 - Feito isso tudo iremos implementar o onClickLogout, este metodo realiza a desconfiguração do acesso 
ao aplicativo, removendo das preferencias o usuario e senha, sendo assim ao acessar o aplicativo novamente 
teremos que colocar o usuario e a senha novamente:
        Não esqueça de estender a classe SaveSharedPreference, para ser usada no método
        private val saveSharedPreference = SaveSharedPreference()
        
        fun onClickLogout(view: View) {
                saveSharedPreference.setLoggedIn(applicationContext, false)
                Toast.makeText(this, "Logout com Sucesso", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
        }
        
        OBS: Agora uma dica muito importante, caso não configure o onBackPressed na aplicação, 
        ela irá sempre retornar para a tela de login, e não queremos que isso aacontessa quando 
        já realizamos o acesso com o usuário e asenha. Esta parte deixarei com vocês.
# GREPE
Olá pessoal!

Estou aprendendo Kotlin e iniciando no uso do Git.

Neste repo, como gosto de resultados já visualizando o design de interfaces, comecei pesquisando e me familiarizando com a vinculação de visualizações 
através da função BINDING.
Ela substitui a função findViewByID e, facilmente, pode interagir com os componentes de forma mais direta.

Para alterar o texto de um componente textView, de forma padrão, achei bem confuso e pouco intuitivo. Assim, decidi experimentar esta opção a qual 
pode referenciar qualquer view do projeto da seguinte forma:

- Inicialmente, devemos ativa-la alterando o build.gradle (módulo: app), adicionando o seguinte trecho dentro do corpo "android { }"
  buildFeatures {
      viewBinding = true
  }
- Logo após, sincronizamos esta modificação para atualizar as funções do projeto.
  Para isto, com o Android Studio, apenas cliquei em qualquer parte do código do trecho que inseri acima, 
  uma lampada apareceu e, ao clicar nela, apareceu a opção "Sync now". Depois de sincronizar, a função inicial da MainActivity, editei para ficar assim:
  
  private lateinit var binding: ActivityMainBinding      // Referência inicial
  
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)     // Aqui está o uso deste recurso
        val view = binding.root
        setContentView(view)
    }
- E aqui um exemplo de uso após estas declarações iniciais:

  binding.textViewNomeDoServidor.setText("Fulano de tal")
  binding.editTextMatricula.text.toString()

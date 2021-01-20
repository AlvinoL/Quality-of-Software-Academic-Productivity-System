import java.util.InputMismatchException;
import java.util.Scanner;

public class appAcademicProductivity {
    public static void main(String[] args) {
        //criando colaboradores
        Professor profA = new Professor("Dumbledore", "dumbledore@email.com", null);
        Aluno alunoG = new Aluno("Alvino", "alvino@email.com", null, 0);
        Aluno alunoM = new Aluno("Pedro", "pedro@email.com", null, 1);
        Aluno alunoD = new Aluno("Duda", "duda@email.com", null, 2);
        Pesquisador pesq = new Pesquisador("Cristopher", "cristopher@email.com", null);

        Projeto newProj = new Projeto("new smartwatch"
                , "07-12-2020", "08-12-2021"
                , "Samsung", 1000000
                , "Desenvolver o novo smartwatch Samsung", "text-description", profA, null, new ProducaoAcademica(5, 1));


        ListaColaboradores listaProf = new ListaColaboradores(2);
//        ListaColaboradores listaAlunos = new ListaColaboradores(2);

        //criando Laboratorio
        Lab lab = new Lab(new ListaColaboradores(10), new ListaProjetos(10), new ProducaoAcademica(10, 10));

//        lab.setAllColabs(new ListaColaboradores(10));
        lab.allColabs.addColab(profA);
        listaProf.addColab(profA);
        lab.allColabs.addColab(alunoM);
        lab.allColabs.addColab(alunoD);
        lab.allColabs.addColab(pesq);
        newProj.setParticipantes(lab.allColabs);
        lab.allColabs.addColab(alunoG);

        Orientacao orientA = new Orientacao(profA, alunoM);
        newProj.projProdAcad.addOrientacao(orientA);
        lab.allProdAcad.addOrientacao(orientA);
        orientA.setOrientando(alunoD);
        newProj.projProdAcad.addOrientacao(orientA);
        lab.allProdAcad.addOrientacao(orientA);
        lab.allProjs.addProjeto(newProj);


        System.out.println("\n");
//        System.out.println(lab.toString());


        //tipos de entradas
        Scanner my_input = new Scanner(System.in);
        int num;
        String text;
        double numD;
        //////////////////

        //interface de usuario
        while (true) {
            System.out.println("Aperte Enter para Continuar\n");
            my_input.nextLine(); // esvazia o buffer
            System.out.println("Digite um codigo de comando:\n");
            System.out.println("101:Criar Projeto;\n202:Editar Projeto; \n303:Consultar Colaborador; \n404:Fechar Programa; \n505:Consultar Projeto; \n" +
                    "606:Relatorio de Produção Academica do Lab\n");
            num = my_input.nextInt();
            my_input.nextLine(); // esvazia o buffer

            //fechar app
            if (num == 404) {
                break;
            }

            //Criar Projeto
            if (num == 101) {
                Projeto proj = new Projeto(null, null, null, null, 0.00, null, null, null, null, null);

                System.out.println("\nCriando Projeto...\n");
                System.out.println("Digite um Titulo:\n");
                text = my_input.nextLine();
                proj.setTitulo(text);

                my_input.nextLine(); // esvazia o buffer

                System.out.println("Digite a data de inicio no formato(dd-mm-aaaa):\n");
                text = my_input.nextLine();
                proj.setInicioData(text);

                my_input.nextLine(); // esvazia o buffer

                System.out.println("Digite a data de termino no formato(dd-mm-aaaa):\n");
                text = my_input.nextLine();
                proj.setTerminoData(text);

                my_input.nextLine(); // esvazia o buffer

                System.out.println("Digite a Agencia Financiadora:\n");
                text = my_input.nextLine();
                proj.setAgFinanciadora(text);

                my_input.nextLine(); // esvazia o buffer

//                System.out.println("Digite o Valor Financiado:\n");
                boolean concluido = false;
                while(!concluido){
                    my_input.nextLine(); // esvazia o buffer
                    System.out.println("Digite o Valor Financiado:\n");
                    try{
                        numD = my_input.nextDouble();
                        proj.setValorFinanciado(numD);
                        System.out.println("Valor Financiado salvo!! OK");
                        concluido = true;
                    }catch (InputMismatchException errorDouble){
                        System.out.println("Voce deve digitar um valor numerico\n");
                    }
                }


                my_input.nextLine(); // esvazia o buffer

                System.out.println("Digite o Objetivo:\n");

                text = my_input.nextLine();
                proj.setObjetivo(text);

                my_input.nextLine(); // esvazia o buffer

                System.out.println("Digite a Descrição:\n");
                text = my_input.nextLine();
                proj.setDescricao(text);

                my_input.nextLine(); // esvazia o buffer

                System.out.println("Digite o codigo do Professor Responsavel:\n");
                for (int i = 0; i < listaProf.getListaColaboradores().length; i++) {
                    if (listaProf.getListaColaboradores()[i] != null) {
                        System.out.println("code:" + listaProf.getListaColaboradores()[i].getId() + " - " + "Professor:" + listaProf.getListaColaboradores()[i].getNome());
                    }
                }
                num = my_input.nextInt();
                proj.setProfessorResponsavel((Professor) listaProf.getListaColaboradores()[num]);
                //lista colaboradores current
                ListaColaboradores curr_part = new ListaColaboradores(10);
                //Projeto pode ter até 5 orientações e 2 publicações
                ProducaoAcademica curr_prod = new ProducaoAcademica(5, 2);
                curr_part.addColab(proj.getProfessorResponsavel());

                my_input.nextLine(); // esvazia o buffer

                while (true) {
                    System.out.println("Deseja adicionar mais algum colaborador ao Projeto? Digite 0: Sim ; 1:Não\n");
                    num = my_input.nextInt();

                    if (num == 1) {
                        my_input.nextLine(); // esvazia o buffer
                        break;
                    }
                    my_input.nextLine(); // esvazia o buffer

                    System.out.println("Digite o codigo do Colaborador:\n");
                    for (int i = 0; i < lab.allColabs.getListaColaboradores().length; i++) {
                        if (lab.allColabs.getListaColaboradores()[i] != null) {
                            // se Aluno
                            if ((lab.allColabs.getListaColaboradores()[i]) instanceof Aluno) {
                                // se Aluno de Graduação
                                if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getTypeAluno() == 0) {
                                    // se o Aluno não possui projeto
                                    if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getBusy() == false) {
                                        System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Aluno de Graduação:" + lab.allColabs.getListaColaboradores()[i].getNome());
                                    }
                                }
                                //se Aluno de Mestrado
                                if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getTypeAluno() == 1) {
                                    System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Aluno de Mestrado:" + lab.allColabs.getListaColaboradores()[i].getNome());
                                }
                                //se Aluno de Doutorado
                                if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getTypeAluno() == 2) {
                                    System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Aluno de Doutorado:" + lab.allColabs.getListaColaboradores()[i].getNome());
                                }
                            }


                            if ((lab.allColabs.getListaColaboradores()[i]) instanceof Professor) {
                                System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Professor:" + lab.allColabs.getListaColaboradores()[i].getNome());

                            }
                            if ((lab.allColabs.getListaColaboradores()[i]) instanceof Pesquisador) {
                                System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Pesquisador:" + lab.allColabs.getListaColaboradores()[i].getNome());
                            }
                        }

                    }
                    //recebe o colaborador do teclado
                    num = my_input.nextInt();
                    my_input.nextLine(); // esvazia o buffer
                    if ((lab.allColabs.getListaColaboradores()[num]) instanceof Aluno) {
                        //indica que o aluno está alocado a um projeto
                        ((Aluno) lab.allColabs.getListaColaboradores()[num]).setBusy(true);
                        //atribui o Aluno ao par Orientação
                        Orientacao currOrient = new Orientacao(null, ((Aluno) lab.allColabs.getListaColaboradores()[num]));
                        curr_part.addColab(lab.allColabs.getListaColaboradores()[num]);
                        System.out.println("Escolha um Professor na lista acima como orientor desse Aluno:\n");
                        num = my_input.nextInt();
                        //cria par Orientação atual
                        currOrient.setOrientador(((Professor) lab.allColabs.getListaColaboradores()[num]));
                        //add Orientação a Lista atual
                        curr_prod.addOrientacao(currOrient);
                        lab.allProdAcad.addOrientacao(currOrient);
                        //add Orientação aos participantes
//                        Professor curr;
//                        curr = lab.allColabs.getListaColaboradores()[currOrient.getOrientador().id];

                    } else {
                        curr_part.addColab(lab.allColabs.getListaColaboradores()[num]);
                    }

                    my_input.nextLine(); // esvazia o buffer
                }

                //add participantes a instancia projeto
                proj.setParticipantes(curr_part);
                //add Orientações a Produção Academica do Projeto
                proj.setProjProdAcad(curr_prod);
                //add Projeto a Lista de Projetos do Lab
                lab.allProjs.addProjeto(proj);


            }
            my_input.nextLine(); // esvazia o buffer

//editar Projeto ////////////////////////////////////////////////////////
            if (num == 202) {
                //editar Projeto
                System.out.println("Qual tipo de edição deseja? Digite 0:Edição de dados cadastrados ;  1:Edição de Status do Projeto\n");
                num = my_input.nextInt();

                //Edição de dados cadastrados
                if (num == 0) {
                    my_input.nextLine(); // esvazia o buffer
                    System.out.println("Escolha o codigo do Projeto desejado...");
                    System.out.println("Edição possível apenas nos Projetos(Em Elaboração):");
                    for (int i = 0; i < lab.allProjs.getListaProjetos().length; i++) {
                        if (lab.allProjs.getListaProjetos()[i] != null) {
                            if ((lab.allProjs.getListaProjetos()[i].getStatus().getCurrentState()) instanceof EmElaboracaoState) {
                                System.out.println("code:" + lab.allProjs.getListaProjetos()[i].getId() + " - " + "Projeto:" + lab.allProjs.getListaProjetos()[i].getTitulo());
                            }
                        }
                    }

                    num = my_input.nextInt();
                    int curr_buff_num = num; // Posição no array do Projeto atual
                    Projeto proj = new Projeto(null, null, null, null, 0.00, null, null, null, null, null);
                    proj = lab.allProjs.getListaProjetos()[num];
                    my_input.nextLine(); // esvazia o buffer
                    while (true) {
                        System.out.println("Qual campo do Projeto deseja editar?");
                        System.out.println("0:Cancelar; 1:Titulo; 2:Data de Inicio; 3:Data de Termino; 4:Ag Financiadora; 5:Valor Financiado; 6:Objetivo; 7:Descrição;");

                        num = my_input.nextInt();
                        my_input.nextLine(); // esvazia o buffer

                        if (num == 1) {
                            System.out.println("Digite um Titulo:\n");
                            text = my_input.nextLine();
                            proj.setTitulo(text);
                            lab.allProjs.getListaProjetos()[curr_buff_num] = proj;

                            my_input.nextLine(); // esvazia o buffer
                        }
                        if (num == 2) {
                            System.out.println("Digite a data de inicio no formato(dd-mm-aaaa):\n");
                            text = my_input.nextLine();
                            proj.setInicioData(text);
                            lab.allProjs.getListaProjetos()[curr_buff_num] = proj;

                            my_input.nextLine(); // esvazia o buffer
                        }
                        if (num == 3) {
                            System.out.println("Digite a data de termino no formato(dd-mm-aaaa):\n");
                            text = my_input.nextLine();
                            proj.setTerminoData(text);
                            lab.allProjs.getListaProjetos()[curr_buff_num] = proj;

                            my_input.nextLine(); // esvazia o buffer
                        }
                        if (num == 4) {
                            System.out.println("Digite a Agencia Financiadora:\n");
                            text = my_input.nextLine();
                            proj.setAgFinanciadora(text);
                            lab.allProjs.getListaProjetos()[curr_buff_num] = proj;

                            my_input.nextLine(); // esvazia o buffer

                        }
                        if (num == 5) {
//                            System.out.println("Digite o Valor Financiado:\n");
                            boolean concluido = false;
                            while(!concluido){
                                my_input.nextLine(); // esvazia o buffer
                                System.out.println("Digite o Valor Financiado:\n");
                                try{
                                    numD = my_input.nextDouble();
                                    proj.setValorFinanciado(numD);
                                    lab.allProjs.getListaProjetos()[curr_buff_num] = proj;
                                    System.out.println("Valor Financiado salvo!! OK");
                                    concluido = true;
                                }catch (Exception errorDouble){
                                    System.out.println("Voce deve digitar um valor numerico\n");
                                }
                            }

                            my_input.nextLine(); // esvazia o buffer

                        }
                        if (num == 6) {
                            System.out.println("Digite o Objetivo:\n");
                            text = my_input.nextLine();
                            proj.setObjetivo(text);
                            lab.allProjs.getListaProjetos()[curr_buff_num] = proj;

                            my_input.nextLine(); // esvazia o buffer
                        }
                        if (num == 7) {
                            System.out.println("Digite a Descrição:\n");
                            text = my_input.nextLine();
                            proj.setDescricao(text);
                            lab.allProjs.getListaProjetos()[curr_buff_num] = proj;

                            my_input.nextLine(); // esvazia o buffer
                        }
                        if (num == 0) {
                            break;
                        }
                    }

                }
                my_input.nextLine(); // esvazia o buffer
                if (num == 1) {
                    //Edição de Status do Projeto
                    System.out.println("Escolha o codigo do Projeto desejado:");
                    for (int i = 0; i < lab.allProjs.getListaProjetos().length; i++) {
                        if (lab.allProjs.getListaProjetos()[i] != null) {
                            if (lab.allProjs.getListaProjetos()[i].getStatus().getCurrentState() instanceof EmElaboracaoState) {
                                //Em Elaboração
                                System.out.println("code:" + lab.allProjs.getListaProjetos()[i].getId() + " - " + "Projeto:" + lab.allProjs.getListaProjetos()[i].getTitulo() + " - " + "Em Elaboração");
                            }
                            if (lab.allProjs.getListaProjetos()[i].getStatus().getCurrentState() instanceof EmAndamentoState) {
                                //Em Andamento
                                System.out.println("code:" + lab.allProjs.getListaProjetos()[i].getId() + " - " + "Projeto:" + lab.allProjs.getListaProjetos()[i].getTitulo() + " - " + "Em Andamento");
                            }
                        }
                    }

                    num = my_input.nextInt();
                    int curr_buff_num = num;
                    Projeto proj = new Projeto(null, null, null, null, 0, null, null, null, null, null);
                    proj = lab.allProjs.getListaProjetos()[curr_buff_num];
                    my_input.nextLine(); // esvazia o buffer
                    if (proj.getStatus().getCurrentState() instanceof EmElaboracaoState) {
                        //Modificar de Elaboração p/ Andamento
                        proj.nextStatus();
                        lab.allProjs.getListaProjetos()[curr_buff_num] = proj;
                        System.out.println("Projeto alterado para Em Andamento.\n");
                    } else if (proj.getStatus().getCurrentState() instanceof EmAndamentoState) {
                        //Modificar de Andamento p/ Concluido
                        Publicacao curr_pub = new Publicacao(null, null, 0, null, null);
                        System.out.println("Preencha uma Publicação para esse Projeto...");

                        System.out.println("Digite um Titulo:\n");
                        text = my_input.nextLine();
                        curr_pub.setTitulo(text);

                        my_input.nextLine(); // esvazia o buffer

                        System.out.println("Digite o nome da Conferencia:\n");
                        text = my_input.nextLine();
                        curr_pub.setNomeConferencia(text);

                        my_input.nextLine(); // esvazia o buffer

                        System.out.println("Digite o ano da Conferencia:\n");
                        num = my_input.nextInt();
                        curr_pub.setAnoPublicacao(num);

                        my_input.nextLine(); // esvazia o buffer

                        curr_pub.setProjeto(proj);
                        curr_pub.setAutores(proj.getParticipantes());
                        proj.projProdAcad.addPublicacao(curr_pub);

                        proj.nextStatus();
                        lab.allProjs.getListaProjetos()[curr_buff_num] = proj;
                        lab.allProdAcad.addPublicacao(curr_pub);
                        System.out.println("Projeto Concluido com Sucesso!\n");

                    }

                }
            }

            if (num == 303) {
                //consultar colaborador
                System.out.println("Digite o codigo do Colaborador que deseja consultar:\n");
                for (int i = 0; i < lab.allColabs.getListaColaboradores().length; i++) {
                    if (lab.allColabs.getListaColaboradores()[i] != null) {
                        // se Aluno
                        if ((lab.allColabs.getListaColaboradores()[i]) instanceof Aluno) {
                            // se Aluno de Graduação
                            if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getTypeAluno() == 0) {
                                // se o Aluno não possui projeto
                                if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getBusy() == false) {
                                    System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Aluno de Graduação:" + lab.allColabs.getListaColaboradores()[i].getNome());
                                }
                            }
                            //se Aluno de Mestrado
                            if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getTypeAluno() == 1) {
                                System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Aluno de Mestrado:" + lab.allColabs.getListaColaboradores()[i].getNome());
                            }
                            //se Aluno de Doutorado
                            if (((Aluno) lab.allColabs.getListaColaboradores()[i]).getTypeAluno() == 2) {
                                System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Aluno de Doutorado:" + lab.allColabs.getListaColaboradores()[i].getNome());
                            }
                        }


                        if ((lab.allColabs.getListaColaboradores()[i]) instanceof Professor) {
                            System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Professor:" + lab.allColabs.getListaColaboradores()[i].getNome());

                        }
                        if ((lab.allColabs.getListaColaboradores()[i]) instanceof Pesquisador) {
                            System.out.println("code:" + lab.allColabs.getListaColaboradores()[i].getId() + " - " + "Pesquisador:" + lab.allColabs.getListaColaboradores()[i].getNome());
                        }
                    }

                }
                num = my_input.nextInt();
                System.out.println("Nome: " + lab.allColabs.getListaColaboradores()[num].getNome());
                System.out.println("Nome: " + lab.allColabs.getListaColaboradores()[num].getEmail());
//                System.out.println(lab.allColabs.getListaColaboradores()[num].toString());
                my_input.nextLine(); // esvazia o buffer
            }

                if (num == 505) {
                    //Consultar Projeto
                    System.out.println("Escolha o codigo do Projeto que deseja consultar:");
                    for (int i = 0; i < lab.allProjs.getListaProjetos().length; i++) {
                        if (lab.allProjs.getListaProjetos()[i] != null) {
                            System.out.println("code:" + lab.allProjs.getListaProjetos()[i].getId() + " - " + "Projeto:" + lab.allProjs.getListaProjetos()[i].getTitulo());

                        }
                    }
                    num = my_input.nextInt();
                    System.out.println(lab.allProjs.getListaProjetos()[num].toString());
                    System.out.println("Titulo: " + lab.allProjs.getListaProjetos()[num].getTitulo());
                    System.out.println("Data de Inicio: " + lab.allProjs.getListaProjetos()[num].getInicioData());
                    System.out.println("Data de Termino: " + lab.allProjs.getListaProjetos()[num].getTerminoData());
                    System.out.println("Agencia Financiadora: " + lab.allProjs.getListaProjetos()[num].getAgFinanciadora());
                    System.out.println("Valor Financiado: " + lab.allProjs.getListaProjetos()[num].getValorFinanciado());
                    System.out.println("Objetivo: " + lab.allProjs.getListaProjetos()[num].getObjetivo());
                    System.out.println("Descrição: " + lab.allProjs.getListaProjetos()[num].getDescricao());
                    if(lab.allProjs.getListaProjetos()[num].getStatus().getCurrentState() instanceof EmElaboracaoState){
                        System.out.println("Status: Em Elaboração");
                    }
                    if(lab.allProjs.getListaProjetos()[num].getStatus().getCurrentState() instanceof EmAndamentoState){
                        System.out.println("Status: Em Andamento");
                    }
                    if(lab.allProjs.getListaProjetos()[num].getStatus().getCurrentState() instanceof ConcluidoState){
                        System.out.println("Status: Concluido");
                    }
                    System.out.println(lab.allProjs.getListaProjetos()[num].getParticipantes().toString());
                    System.out.println(lab.allProjs.getListaProjetos()[num].getProjProdAcad().toString());
                    my_input.nextLine(); // esvazia o buffer
                }

                if (num == 606) {
                    //Relatorio de Produção Academica do Lab
                    int count_colabs=0;
                    int count_projs=0;
                    int count_elab = 0;
                    int count_andam=0;
                    int count_done=0;
                    int count_orient=0;
                    int count_pub=0;
                    for(int i = 0; i < lab.allColabs.getListaColaboradores().length; i++){
                        if(lab.allColabs.getListaColaboradores()[i] != null){
                            count_colabs++;
                        }
                    }
//                    for(int i = 0; i < lab.allProjs.getListaProjetos().length; i++){
//                        if(lab.allProjs.getListaProjetos()[i] != null){
//                            count_projs++;
//                        }
//                    }
                    for(int i = 0; i < lab.allProjs.getListaProjetos().length; i++){
                        if(lab.allProjs.getListaProjetos()[i] != null){
                            if (lab.allProjs.getListaProjetos()[i].getStatus().getCurrentState() instanceof EmElaboracaoState) {
                                //Em Elaboração
                                count_elab++;
                            }
                            if (lab.allProjs.getListaProjetos()[i].getStatus().getCurrentState() instanceof EmAndamentoState) {
                                //Em Andamento
                                count_andam++;
                            }
                            if (lab.allProjs.getListaProjetos()[i].getStatus().getCurrentState() instanceof ConcluidoState) {
                                //Em Andamento
                                count_done++;
                            }
                            count_projs++;
                        }
                    }
                    for(int i = 0; i < lab.allProdAcad.getListaOrientacao().length; i++){
                        if(lab.allProdAcad.getListaOrientacao()[i] != null){
                            count_orient++;
                        }
                    }
                    for(int i = 0; i < lab.allProdAcad.getListaPublicacao().length; i++){
                        if(lab.allProdAcad.getListaPublicacao()[i] != null){
                            count_pub++;
                        }
                    }
                    System.out.println("Número de Colaboradores: " + count_colabs);
                    System.out.println("Número de Projetos Em Elaboração: " + count_elab);
                    System.out.println("Número de Projetos Em Andamento: " + count_andam);
                    System.out.println("Número de Projetos Concluídos: " + count_done);
                    System.out.println("Número de Projetos: " + count_projs);
                    System.out.println("Número de Orientações: " + count_orient);
                    System.out.println("Número de Publicações: " + count_pub);
                    my_input.nextLine(); // esvazia o buffer
                }

            } // fim do while de programa

//            System.out.println("\n");
////        System.out.println(lab.toString());
//            System.out.println(lab.getAllColabs());
//            System.out.println("\n");
//            System.out.println(lab.getAllProjs());
//            System.out.println("\n");
//            System.out.println(lab.getAllProdAcad());
        }
    }


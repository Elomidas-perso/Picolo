package elomidas.picolympe;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by GAMING on 11/08/2017.
 */

public class Jeu
{
    protected static Random _rand = new Random(System.currentTimeMillis());
    protected ArrayList<Manche> _tas;
    protected ArrayList<Manche> _wait;
    protected ArrayList<String> _players;

    //Données fixes
    protected static final String _FICHIER_CONFIG = "config.cfg";

    public Jeu(ArrayList<String> p) {
        _tas = new ArrayList<>();
        _wait = new ArrayList<>();
        _players = p;
        String[] couleurs = new String[] {"rouge", "vert", "jaune", "bleu", "noir", "blanc"};
        String temp;
        Log.d("Nb Players ", "" + _players.size());


        //Ajout des manche générales
        //Simples
        _tas.add(new Manche("Si tu as " + ((_rand.nextInt(100) < 50) ? "moins" : "plus") + " de 20 ans, " + ((_rand.nextInt(100) < 50) ? "boit" : "donne") + " 1 gorgée par année."));
        _tas.add(new Manche("Tous ceux qui " + ((_rand.nextInt(100) < 50) ? "ont des" : "n'ont pas de") + " lunettes boivent."));
        _tas.add(new Manche("Le plus agé " + ((_rand.nextInt(100) < 50) ? "donne " : "boit ") + (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("Le plus jeune " + ((_rand.nextInt(100) < 50) ? "donne " : "boit ") + (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("Les étudiants " + ((_rand.nextInt(100) < 50) ? "donnent " : "boivent ") + (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("Ceux qui ont le permis " + ((_rand.nextInt(100) < 50) ? "donnent " : "boivent ") + (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("Ceux qui n'ont pas le permis " + ((_rand.nextInt(100) < 50) ? "donnent " : "boivent ") + (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("Tous ceux qui " + ((_rand.nextInt(100) < 50) ? "ont déjà" : "n'ont jamais") + " triché à un examen boivent " + (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("La dernière personne à être allée aux toilettes boit 5 gorgées."));
        _tas.add(new Manche("Ceux qui ont déjà travailler au noir " + ((_rand.nextInt(100) < 50) ? "donnent " : "boivent ") + (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("Les joueurs qui n'ont pas distribué de gorgées en boivent " + (2 + _rand.nextInt(4))));
        _tas.add(new Manche("Le dernier arrivé boit 4 gorgées."));
        for(int i = 0; i < 2; i++)
        {
            _tas.add(new Manche("Le dernier à toucher du " + couleurs[_rand.nextInt(couleurs.length)] + " boit 3 gorgées"));
            _tas.add(new Manche("Les " + ((_rand.nextInt(100) < 50) ? "mecs" : "filles") + ((_rand.nextInt(100) < 50) ? " boivent" : " donnent") + " 2 gorgées."));
        }
        for(int i = 0; i < _players.size() / 4.0; i++)
        {
            _tas.add(new Manche(Decode("%p distribue " + (4 + _rand.nextInt(7)) + " gorgées.")));
            _tas.add(new Manche(Decode("Pierre Feuille Ciseaux entre %p et %p\nLe perdant boit " + (2 + _rand.nextInt(4)) + " gorgées.\nLe gagnant en distribue " + (2 + _rand.nextInt(4)) + ".")));
        }
        //Doubles
        _tas.add(new Manche("Tout le monde pointe un autre joueur.", "Le plus pointé " + ((_rand.nextInt(100) < 50) ? "boit" : "donne") + " 3 gorgées.", 0));
        _tas.add(new Manche("Tout le monde pointe un autre joueur.", "Le moins pointé " + ((_rand.nextInt(100) < 50) ? "boit" : "donne") + " 3 gorgées.", 0));
        _tas.add(new Manche("Elisez les 2 plus chiants d'entre vous.", "Ils " + ((_rand.nextInt(100) < 50) ? "boivent " : "donnent ") + (2 + _rand.nextInt(4)) + " gorgées chacun.", 0));
        temp = Decode("%p");
        _tas.add(new Manche("Tous ceux qui regardent " + temp + " boivent 2 gorgées jusqu'à nouvel ordre.", "On peut de nouveau regarder " + temp +"."));
        for (int i = 0; i < 2; i++)
        {
            _tas.add(new Manche("Tout le monde lève 1 à 5 doigts.", "Les nombres " + ((_rand.nextInt(100) < 50) ? "impairs" : "pairs") + ((_rand.nextInt(100) < 50) ? " donnent" : " boivent") + " 1 gorgée par doigt.", 0));
        }

        //Ajout des thèmes
        _tas.add(new Manche(Decode("Thème : Pokémon G1\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));
        _tas.add(new Manche(Decode("Thème : Films Disney\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));
        _tas.add(new Manche(Decode("Thème : Etats des USA\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));
        _tas.add(new Manche(Decode("Thème : Midi les Zouzous\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));
        _tas.add(new Manche(Decode("Thème : Villes allemandes\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));
        _tas.add(new Manche(Decode("Thème : Instruments à vent\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));
        _tas.add(new Manche(Decode("Thème : Instruments à cordes\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));
        _tas.add(new Manche(Decode("Thème : Signes astrologiques\n" + (2 + _rand.nextInt(4)) + " gorgées en jeu, %p commence.")));

        //Ajout des jeux
        _tas.add(new Manche("Chaque joueur épèle le nom de son voisin de droite.\n2 gorgées par faute.\nAbandon = cul sec."));
        _tas.add(new Manche(Decode("%p lance un \"Dans ma valise\", "  + (2 + _rand.nextInt(4)) +  " gorgées en jeu.")));
        for(int i = 0; i < _players.size() / 4.0; i++)
        {
            _tas.add(new Manche(Decode("Action ou vérité pour %p.")));
            _tas.add(new Manche(Decode("Le premier à balancer un dossier sur %p distribue " + (2 + _rand.nextInt(4)) + " gorgées.")));
            _tas.add(new Manche(Decode("%p peut donner autant de gorgées qu'il/elle le souhaite à %p.")));
        }


        //Ajout des règles
        _tas.add(new Manche("Bufalo : tout le monde boit de sa main secondaire ou fini son verre."));
        _tas.add(new Manche("Alcool ! : si qqn fini son verre, il doit redemander à boire tout de suite ou boire 6 gorgées."));
        _tas.add(new Manche("Tout le monde boit "+ (2 + _rand.nextInt(5)) + " gorgées."));
        _tas.add(new Manche("Plus aucun pronom personnel (Je, Tu, Il, etc...)"));
        _tas.add(new Manche("Dès qu'un joueur nous caresse l'oreille, on boit.", "On ne boit plus si on se fait toucher l'oreille"));
        _tas.add(new Manche("On peut jouer ses gorgées à pile ou face.\nPile on les redistribue.\nFace on en boit le double."));
        _tas.add(new Manche("Toutes les gorgées sont doublées.", "Les gorgées ne sont plus doublées."));
        _tas.add(new Manche("Toutes nos gorgées sont renvoyées sur le joueur à notre " + ((_rand.nextInt(100) < 50) ? "droite" : "gauche") + ".", "Chacun se remet à boire ses propres gorgées."));

        //Ajout des défis
        ArrayList<String> defis = new ArrayList<>();
        ArrayList<String> fins = new ArrayList<>();
        //Mate
        defis.add("%p doit boire à chaque fois que %p boit pour le jeu.");
        fins.add("%p n'est plus obligé de boire avec %p.");
        //Questions
        defis.add("Si on qqn répond aux questions de %p, il boit 3 gorgées.");
        fins.add("On peut à nouveau répondre aux questions de %p.");
        //Pouce
        defis.add("Si %p met son doigt sur son front, tout le monde l'imite. 3 gorgées au perdant.");
        fins.add("Si %p met son doigt sur son front, il est juste débile, plus la peine de suivre.");
        //Sing
        defis.add("%p doit maintenant parler en chantant ou boire 1 gorgée par mot.");
        fins.add("%p n'a plus besoin de chanter.");
        //D'après une étude
        defis.add("%p doit commencer chaque phrase par \"D'après une étude\" ou boire 4 gorgées.");
        fins.add("%p n'a plus besoin de citer une étude à chaque fois.");
        //Dans ton cul
        defis.add("%p doit finir toutes ses phrases par \"dans ton cul\" ou boire 4 gorgées.");
        fins.add("%p arrête avec les \"dans ton cul\".");
        //Je me demande...
        defis.add("%p ne peut que poser des questions, sinon il boit 4 gorgées.");
        fins.add("%p n'est plus obligé de poser des questions.");
        //Elève modèle
        defis.add("%p demande la parole à %p avant de parler ou boit 4 gorgées.");
        fins.add("%p n'a plus besoin de demander la parole.\n%p boit 4 gorgées.");
        //Anglophone
        defis.add("%p doit maintenant parler anglais, il faut lui répondre en anglais. 4 gorgées aux contrevenants.");
        fins.add("%p n'est plus anglophone, on peut lui répondre en français.");
        //Sportif
        defis.add("%p doit faire 5 pompes avant de parler, ou boire 5 gorgées.");
        fins.add("%p n'a plus besoin de faire de pompes.");


        InitDefis(defis, fins);
    }

    /*
    protected ArrayList<String>[] LoadConfig()
    {
        ArrayList<String> manchesUn, manchesDeux, themes, regles, defis, fins;
        manchesUn = new ArrayList<>();
        manchesDeux = new ArrayList<>();
        themes = new ArrayList<>();
        regles = new ArrayList<>();
        defis = new ArrayList<>();
        fins = new ArrayList<>();
        try
        {
            //Lecture des fichiers
            FileInputStream fConfigIn = new FileInputStream(_FICHIER_CONFIG);
            BufferedReader rConfig = new BufferedReader(new FileReader(_FICHIER_CONFIG));
            String[] names = new String[6];
            for(int i = 0; i < 6; i++)
            {
                names[i] = rConfig.readLine();
            }

        }
        catch(Exception e)
        {
            if(e instanceof FileNotFoundException)
            {
                //Création des fichiers
                try
                {
                    Log.d("Info ", "Création des fichiers");
                    FileOutputStream fConfigOut = new FileOutputStream(_FICHIER_CONFIG);
                    FileWriter wConfig = new FileWriter(_FICHIER_CONFIG);
                    wConfig.write("manchesSimples.pic\nmanchesDoubles.pic\nthemes.pic\nregles.pic\ndefis.pic\nfins.pic\n");
                    wConfig.close();
                    fConfigOut.close();
                    fConfigOut = new FileOutputStream("manchesSimples.pic");
                    fConfigOut.close();
                    fConfigOut = new FileOutputStream("manchesDoubles.pic");
                    fConfigOut.close();
                    fConfigOut = new FileOutputStream("themes.pic");
                    fConfigOut.close();
                    fConfigOut = new FileOutputStream("regles.pic");
                    fConfigOut.close();
                    fConfigOut = new FileOutputStream("defis.pic");
                    fConfigOut.close();
                    fConfigOut = new FileOutputStream("fins.pic");
                    fConfigOut.close();
                    Log.d("Info ", "Fichiers créés");
                }
                catch(Exception ex)
                {
                    Log.d("Erreur e2 ", ex.getMessage());
                }
            }
            else Log.d("Erreur e1 ", e.getMessage());
        }
        return new ArrayList[] {manchesUn, manchesDeux, themes, regles, defis, fins};
    }

    protected static void Read(ArrayList<String> data, String file)
    {
        try
        {
            BufferedReader rInput = new BufferedReader(new FileReader(file));
            for(int i = 0; i < 6; i++)
            {
                boolean test = false;
                String str = rInput.readLine();
                String res = "";
                for(int j = 0; j < str.length(); j++)
                {
                    switch(str.charAt(j))
                    {
                        case '\\' :
                            if(test)
                                res += '\\';
                            else test = true;
                            break;

                        case 'c':
                            if(test)
                            {
                                res += '\n';
                                test = false;
                            }
                            else res += 'c';
                            break;

                        default:
                            if(test)
                            {
                                res += '\\';
                                test = false;
                            }
                            res += str.charAt(j);
                    }
                }
                data.add(res);
            }
        }
        catch(Exception e)
        {
            Log.d("Erreur e3 ", "Fichier \"" + file + "\", " + e.getMessage());
        }
    }
    */

    protected void InitDefis(ArrayList<String> defis, ArrayList<String> fins)
    {
        ArrayList<String> liste = new ArrayList<>(_players);
        while((defis.size() > 0) && (liste.size() > 0))
        {
            int index = _rand.nextInt(defis.size());
            String str = defis.remove(index);
            int taille = Size(str);
            String[] noms = new String[taille];
            noms[0] = liste.remove(_rand.nextInt(liste.size()));
            ArrayList<String> temp = new ArrayList<>(_players);
            temp.remove(noms[0]);
            for(int i = 1; i < taille; i++)
                noms[i] = temp.remove(_rand.nextInt(temp.size()));
            //Defi
            String def = Decode(str, noms);
            //Fin du défi
            String fin = Decode(fins.remove(index), noms);
            //Ajout au tas
            _tas.add(new Manche(def, fin));
        }
    }

    public String Tour()
    {
        for(int i = 0; i < _wait.size(); i++)
        {
            if(_wait.get(i)._decompte == 0)
                return _wait.remove(i)._indic;
            _wait.get(i)._decompte--;
        }
        if(_tas.size() > 0)
        {
            Manche m = _tas.remove(_rand.nextInt(_tas.size()));
            if(m._next != null)
                _wait.add(0, m._next);
            return m._indic;
        }
        if(_wait.size() > 0)
            return _wait.remove(0)._indic;
        return "The Game Is Over";
    }

    //Retourne le nombre de %p dans une phrase
    protected static int Size(String str)
    {
        int compteur = 0;
        boolean percent = false;
        for(int i = 0; i < str.length(); i++)
        {
            switch (str.charAt(i))
            {
                case '%' :
                    if(!percent)
                        percent = true;
                    break;
                case 'p' :
                    if(percent)
                    {
                        compteur++;
                        percent = false;
                    }
                    break;
                default:
                    percent = false;
                    break;
            }
        }
        return compteur;
    }

    //Transforme les "%s" par des noms de joueurs dans les phrases
    protected String Decode(String str)
    {
        int index = _rand.nextInt(_players.size());
        String[] tab = new String[_players.size()];
        tab[0] = _players.get(index);
        for(int i = 1; i < _players.size(); i++)
            tab[i] = _players.get((i <= index) ? i - 1 : i);
        return Decode(str, tab);
    }

    protected static String Decode(String str, String[] names)
    {
        String res = "";
        int iterator = 0;
        boolean percent = false;
        for(int i = 0; i < str.length(); i++)
        {
            switch (str.charAt(i))
            {
                case '%' :
                    if(percent)
                        res += '%';
                    else percent = true;
                    break;
                case 'p' :
                    if(percent)
                    {
                        res += names[iterator];
                        iterator++;
                        percent = false;
                    }
                    else res += 'p';
                    break;
                default:
                    if(percent)
                        res += '%';
                    percent = false;
                    res += str.charAt(i);
                    break;
            }
        }
        return res;
    }

    /**
     * Created by GAMING on 11/08/2017.
     */

    public static class Manche
    {
        public String _indic;
        public int _decompte;
        public Manche _next;

        public Manche(String indic)
        {
            _indic = indic;
            _next = null;
            _decompte = -1;
        }

        public Manche(String indic, int decompte)
        {
            _indic = indic;
            _next = null;
            _decompte = decompte;
        }

        public Manche(String indic, String suiv, int decompte)
        {
            _indic = indic;
            _next = new Manche(suiv, decompte);
            _decompte = -1;
        }

        public Manche(String indic, String suiv)
        {
            _next = new Manche(suiv, 5 + _rand.nextInt(20));
            _decompte = -1;
            _indic = indic;
        }
    }
}

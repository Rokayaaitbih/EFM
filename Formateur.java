
class Formateur
        {
//Les attributs:
private int heureSup;
private static double remunerationHSup = 70.00;
//L'accesseur RemunerationHSup:
public static double RemunerationHSup
        {
        get { return remunerationHSup; }
        set { remunerationHSup = value; }
        }
public int HeureSup
        {
        get { return heureSup; }
        set { heureSup = value; }
        }
//Les deux constructeurs par défaut et d'initialisation:
public Formateur():base()
        {
        heureSup = 0;
        }
public Formateur(string nom, DateTime dateNaissance, DateTime dateEmbauche, double salaireBase, int heureSup)
        : base(nom, dateNaissance, dateEmbauche, salaireBase)
        {
        heureSup = heureSup;
        }
//La méthode SalaireAPayer() pour calculer le salaire net d'un formateur sachant que ...
public override double SalaireAPayer()
        {
        int NbreHS = heureSup;
        if (NbreHS >= 30)
        NbreHS = 30;
        return (salaireBase + NbreHS*_remunerationHSup) * (1 - IR.getIR(salaireBase*12));
        }
//La méthode ToString()
public override string ToString()
        {
        return base.ToString()+"-"+heureSup;
        }
        }
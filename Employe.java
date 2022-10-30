
public abstract class Employe{

//Les attributs (ils doivent être visibles dans les classes filles de la classe Employé)
protected int mtle;
protected String nom;
protected DateTime dateNaissance, dateEmbauche;
protected double salaireBase;
private static int cpt = 0;
public int Matricule()
        {
        get { return mtle; }
        }
public String Nom()
        {
        get { return nom; }
        set { nom = value; }
        }
//Les deux accesseurs DateEmbauche et DateNaissance sachant que l'âge de l'employé à la date d'embauche ne doit être
// inferieure à 16 ans, lever une exception sinon:
public DateTime DateNaissance()
        {
        get { return dateNaissance; }
        set { dateNaissance = value; }
        }
public DateTime DateEmbauche() {
        get {
                return dateEmbauche;
        }
        set
        {
                TimeSpan ts = value - dateNaissance;
                if ((ts.TotalDays / 365) < 16) {
                        throw new Exception("L'âge au recrutement doit être supérieur à 16 ans");
                        dateEmbauche = value;
                }
        }
        public double SalaireBase ()
        {
                get {
                return salaireBase;
        }
                set {
                salaireBase = value;
        }
        }
//Un constructeur par défaut et un autre d'initialisation
public Employe()
        {
                cpt++;
                mtle = cpt;
                nom = "";
                dateEmbauche = DateTime.Now;
                dateNaissance = new DateTime(2000, 1, 1);
                salaireBase = 0;
        }
public Employe(string nom, DateTime dateNaissance, DateTime dateEmbauche, double salaireBase)
        {
                nom = nom;
                dateNaissance = dateNaissance;
                DateEmbauche = dateEmbauche;
                salaireBase = salaireBase;
                cpt++;
                mtle = cpt;
        }
//Une méthode abstraite SalaireAPayer() pour retourner le salaire net d'un employé:
        public abstract double SalaireAPayer ();
//L'implémentation de l'interface IComparable<Employe> pour comparer deux employés par nom.
        public int CompareTo (Employe e)
        {
                return nom.CompareTo(e.nom);
        }
//L'implémentation de l'interface IEmploye avec ses trois méthodes:
        public int Age ()
        {
                TimeSpan ts = DateTime.Now - dateNaissance;
                return (int) ts.TotalDays / 365;
        }
        public int Anciennete ()
        {
                TimeSpan ts = DateTime.Now - dateEmbauche;
                return (int) ts.TotalDays / 365;
        }
        public DateTime DateRetraite ( int ageRetraite)
        {
                TimeSpan ts = new TimeSpan(ageRetraite * 365, 0, 0, 0);
                DateTime dateRetraite = new DateTime(dateNaissance.Year, dateNaissance.Month, dateNaissance.Day).Add(ts);
                return dateRetraite;
        }
//La redéfinition de la méthode ToString() qui renvoie toutes les propriétés séparées par "-".
        public override string ToString()
        {
                return mtle + "-" + nom + "-" + dateNaissance.ToString("dd/MM/yyyy") + "-" + dateEmbauche.ToString("dd/MM/yyyy") + "-" + salaireBase;
        }
//La redéfinition de la méthode Equals() : 2 employés sont égaux s'ils ont le même matricule:
        public override bool Equals(object obj)
        {
                Employe e = obj as Employe;
                if (e == null)
                        return false;
                return mtle == e.mtle;
        }

}}
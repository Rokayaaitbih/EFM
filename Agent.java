class Agent
        {
private double primeResponsabilite;
public double PrimeResponsabilite
        {
        get { return primeResponsabilite; }
        set { primeResponsabilite = value; }
        }
public Agent(string nom, DateTime dateNaissance, DateTime dateEmbauche, double salaireBase, double primeResponsabilite)
        : base(nom, dateNaissance, dateEmbauche, salaireBase)
        {
        primeResponsabilite = primeResponsabilite;
        }
//La méthode SalaireAPayer() pour calculer le salaire net d'un agent sachant que...
public override double SalaireAPayer()
        {
        return (salaireBase+primeResponsabilite)*(1-IR.getIR(salaireBase*12));
        }
        }
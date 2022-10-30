public interface IEmploye
{
    //Une méthode Age() qui retournera l'âge de l'employé:
    int Age();
    //Une méthode Anciennete() qui retournera l'ancienneté d'un employé (le nombre d'années qu'il a travaillé).
    int Anciennete();
    //Une méthode DateRetraite(ageRetraite) pour renvoyer la date de retraite de l'employé:
    DateTime DateRetraite(int ageRetraite);


}
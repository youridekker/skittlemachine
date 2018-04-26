public class Bakje {
    private String kleur;
    private int hoeveelheid;
    private int positieBakje;
    private int huidigeHoeveelheid;

    public String getKleur() {
        return kleur;
    }

    public int getPositieBakje() {
        return positieBakje;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public Bakje(String kleur, int hoeveelheid, int positieBakje, int huidigeHoeveelheid){
        this.kleur = kleur;
        this.hoeveelheid = hoeveelheid;
        this.positieBakje = positieBakje;
        this.huidigeHoeveelheid = huidigeHoeveelheid;
    }

    public void verhoogHuidigeHoeveelheid(int aantal){
        this.huidigeHoeveelheid = this.huidigeHoeveelheid + aantal;
    }

    public boolean isVol(){
        if(this.huidigeHoeveelheid == 50){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return this.hoeveelheid +" "+ this.kleur +" HuidigAantal: "+ this.huidigeHoeveelheid;
    }
}

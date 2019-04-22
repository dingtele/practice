class RemAV
{
    // FishD f = new FishD();
    
    PieD forBot()
    {
        return new Bot();
    }

    PieD forTop(Object o, PieD p)
    {
        if (new Anchovy.equals(o))
            return p.remAV();
        else 
            return new Top(o, p.remAV());
    }






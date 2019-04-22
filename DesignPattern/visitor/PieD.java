abstract class PieD()
{
    VisitF visitF = new VisitF();
    abstract PieD visiF();
}

class Bot extends PieD
{
    PieD visiF()
    {
        return visitor.forBot();
    } 
}

class Top extends PieD
{
    Object t;
    PieD r;

    Top(Object _o, PieD _p)
    {
        o = _o;
        p = _p;
    }

    PieD visiF()
    {
        return visitor.forTop(o, p);
    }
}


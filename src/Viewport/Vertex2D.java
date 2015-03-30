package Viewport;

/**
 * A 2D point or a vector that can be used for performing 2D transformations.
 * @author Mihai
 *
 */
public class Vertex2D 
{
	public double x;
	public double y;
	
	public Vertex2D()
	{
		x=0;y=0;
	}
	
	public Vertex2D(double d, double e)
	{
		this.x=d;
		this.y=e;
	}
	
	public Vertex2D(int x, int y)
	{
		this.x=(float)x;
		this.y=(float)y;
	}
	
	public Vertex2D(Vertex2D s)
	{
		this.x=s.x;
		this.y=s.y;
	}
	
	public Vertex2D plus(Vertex2D b)
	{
		return new Vertex2D(x+b.x, y+b.y);
	}
	
	public Vertex2D minus(Vertex2D b)
	{
		return new Vertex2D(x-b.x, y-b.y);
	}
	
	public Vertex2D mul(Vertex2D b)
	{
		return new Vertex2D(x*b.x, y*b.y);
	}
	
	public Vertex2D div(Vertex2D b)
	{
		return new Vertex2D(x/b.x, y/b.y);
	}
	
	public Vertex2D transform(Matrix3x3 m)
	{
		return new Vertex2D(m.a*x + m.d*y + m.g,  m.b*x + m.e*y + m.h);
	}
	
	public Vertex2D transform(Transform2D e) 
	{
		return transform(e.matrix);
	}
	
	@Override
	public String toString()
	{
		return new String("(" + x + ", " + y + ")");
	}

	
}

package Viewport;

/**
 * A 3 by 3 matrix that can be used for performing 2D transformations
 * @author Mihai
 *
 */
public class Matrix3x3 
{
	public double a, b, c, d, e, f, g, h, i;
	
	
	
	public Matrix3x3(double a, double b, double c, double d, double e, double f, double g, double h, double i)
	{
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
		this.g=g;
		this.h=h;
		this.i=i;
	}
	
	/**
	 * Genereaza matricea identitate
	 */
	public Matrix3x3()
	{
		this.a=1;
		this.b=0;
		this.c=0;
		this.d=0;
		this.e=1;
		this.f=0;
		this.g=0;
		this.h=0;
		this.i=1;
	}
	
	/**
	 * Genereaza matricea cu toate elementele egale
	 */
	public Matrix3x3(double v)
	{
		this.a=v;
		this.b=v;
		this.c=v;
		this.d=v;
		this.e=v;
		this.f=v;
		this.g=v;
		this.h=v;
		this.i=v;
	}
	
	/**
	 * Copiaza Matricea
	 */
	public Matrix3x3(Matrix3x3 B)
	{
		this.a=B.a;
		this.b=B.b;
		this.c=B.c;
		this.d=B.d;
		this.e=B.e;
		this.f=B.f;
		this.g=B.g;
		this.h=B.h;
		this.i=B.i;
	}
	
	public Matrix3x3 getTransposed()
	{
		return new Matrix3x3(
				a, d, g, 
				b, e, h, 
				c, f, i);
	}
	
	public Matrix3x3 getXTransposed()
	{
		return new Matrix3x3(
				g, d, a, 
				h, e, b, 
				i, f, c);
	}
	
	public Matrix3x3 getYTransposed()
	{
		return new Matrix3x3(
				c, f, i, 
				b, e, h, 
				a, d, g);
	}
	
	public Matrix3x3 mul(Matrix3x3 B)
	{
		return new Matrix3x3(
				a*B.a + b*B.d + c*B.g,  a*B.b + b*B.e + c*B.h,  a*B.c + b*B.f + c*B.i,
				d*B.a + e*B.d + f*B.g,  d*B.b + e*B.e + f*B.h,  d*B.c + e*B.f + f*B.i,
				g*B.a + h*B.d + i*B.g,  g*B.b + h*B.e + i*B.h,  g*B.c + h*B.f + i*B.i
				);
	}
	
	public Matrix3x3 getInverted()
	{
		double det=a*(e*i-f*h)-b*(i*d-f*g)+c*(d*h-e*g);
		double A, B, C, D, E, F, G, H, I;
		A=e*i-f*h;
		B=-(d*i-f*g);
		C=d*h-e*g;
		D=-(b*i-c*h);
		E=a*i-c*g;
		F=-(a*h-b*g);
		G=b*f-c*e;
		H=-(a*f-c*d);
		I=a*e-b*d;
		
		return new Matrix3x3(
				A/det, D/det, G/det,
				B/det, E/det, H/det,
				C/det, F/det, I/det
				);
	}
	
	public Matrix3x3 div(Matrix3x3 B)
	{
		return mul(B.getInverted());
	}
	
	public Matrix3x3 plus(Matrix3x3 B)
	{
		return new Matrix3x3(
				a+B.a, b+B.b, c+B.c,
				d+B.d, e+B.e, f+B.f,
				g+B.g, h+B.h, i+B.i
				);
	}
	
	public Matrix3x3 minus(Matrix3x3 B)
	{
		return new Matrix3x3(
				a-B.a, b-B.b, c-B.c,
				d-B.d, e-B.e, f-B.f,
				g-B.g, h-B.h, i-B.i
				);
	}
	
	@Override
	public String toString()
	{
		return new String(
				"|'\t" + a + ", \t" + b + ", \t" + c + "\t'|" + "\n" +
				"| \t" + d + ", \t" + e + ", \t" + f + "\t |" + "\n" +
				"|.\t" + g + ", \t" + h + ", \t" + i + "\t.|" + "\n"
		);
	}
}

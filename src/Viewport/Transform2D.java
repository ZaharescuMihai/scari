package Viewport;



public class Transform2D 
{
	Matrix3x3 matrix;
	
	public Transform2D()
	{
	}
	
	public Transform2D(Transform2D t)
	{
		matrix=new Matrix3x3(t.matrix);
	}
	
	public Vertex2D getTransformed(Vertex2D v)
	{
		return v.transform(matrix);
	}
	
	public Vertex2D getInverseTransformed(Vertex2D v)
	{
		return v.transform(matrix.getInverted());
	}
	
	public void translate(double x, double y)
	{
		Matrix3x3 tran=new Matrix3x3();
		tran.c=x;
		tran.f=y;
		tran=tran.getTransposed();
		
		matrix=matrix.mul(tran);
	}
	
	public void scale(double sx, double sy, double ox, double oy)
	{
		translate(-ox, -oy);
		
		Matrix3x3 tran=new Matrix3x3();
		tran.a=sx;
		tran.e=sy;
		tran=tran.getTransposed();
		
		matrix=matrix.mul(tran);
		
		translate(ox, oy);
	}
	
	public void scale(double sx, double sy)
	{
		Matrix3x3 tran=new Matrix3x3();
		tran.a=sx;
		tran.e=sy;
		tran=tran.getTransposed();
		
		matrix=matrix.mul(tran);
	}
	
	public void rotate(double u, double ox, double oy)
	{
		translate(-ox, -oy);

		double ur=Math.toRadians(u);
		double s, c;
		s=Math.sin(ur);
		c=Math.cos(ur);
		
		Matrix3x3 tran=new Matrix3x3();
		tran.a=c;
		tran.b=-s;
		tran.d=s;
		tran.e=c;
		tran=tran.getTransposed();
		
		matrix=matrix.mul(tran);
		
		translate(ox, oy);
	}
	
	public void rotate(double u)
	{
		double ur=Math.toRadians(u);
		double s, c;
		s=Math.sin(ur);
		c=Math.cos(ur);
		
		Matrix3x3 tran=new Matrix3x3();
		tran.a=c;
		tran.b=-s;
		tran.d=s;
		tran.e=c;
		tran=tran.getTransposed();
		
		matrix=matrix.mul(tran);
	}
	
	public void transform(Transform2D t)
	{
		matrix = matrix.mul(t.matrix);
	}
	
	public void transform(Matrix3x3 mat)
	{
		matrix=matrix.mul(mat);
	}

	public double getXScale()
	{
		return matrix.a;
	}
}

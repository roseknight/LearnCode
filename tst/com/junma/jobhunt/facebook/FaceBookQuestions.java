package com.junma.jobhunt.facebook;

public class FaceBookQuestions {
	public static double sqrt(double x) {
		double diff = 1.0;
		double xn = x/2.0;
		double xnp1 = 0.0;
		while(diff>0.0001) {
			xnp1 = (xn + x/xn)/2.0;
			diff = xnp1 - xn;
			if (diff<0.0) {
				diff = -diff;
			}
			xn = xnp1;
		}
		return xn ;
	}
	
}

package physics;import physics.Geometry.DoublePair;import physics.Geometry.VectPair;/**************************************************************************** * Copyright (C) 1999-2001 by the Massachusetts Institute of Technology, *                       Cambridge, Massachusetts. * *                        All Rights Reserved * * Permission to use, copy, modify, and distribute this software and * its documentation for any purpose and without fee is hereby * granted, provided that the above copyright notice appear in all * copies and that both that copyright notice and this permission * notice appear in supporting documentation, and that MIT's name not * be used in advertising or publicity pertaining to distribution of * the software without specific, written prior permission. * * THE MASSACHUSETTS INSTITUTE OF TECHNOLOGY DISCLAIMS ALL WARRANTIES * WITH REGARD TO THIS SOFTWARE, INCLUDING ALL IMPLIED WARRANTIES OF * MERCHANTABILITY AND FITNESS.  IN NO EVENT SHALL THE MASSACHUSETTS * INSTITUTE OF TECHNOLOGY BE LIABLE FOR ANY SPECIAL, INDIRECT OR * CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS * OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, * NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN * CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE. * * * @author: Matt Frank, MIT Laboratory for Computer Science, *          mfrank@lcs.mit.edu *          1999-Apr-03 * * @author: Rob Pinder, Phil Sarin, Lik Mui *          Spring 2000 *          Exception handling and argument type refinemnt * * @author: Jeffrey Sheldon (jeffshel@mit.edu) *          Fall 2000, Spring 2001 *          Major rewrites and improvements to iterative solving * * @author: Jeremy Nimmer (jwnimmer@alum.mit.edu) *          Fall 2000, Spring 2001 *          Editorial role (testing and specification editing) * * Version: $Id: GeometryInterface.java,v 1.1 2002/08/21 21:49:40 kirky Exp $ * ***************************************************************************//** * This is the interface that the singleton Geometry dispatches to. * Callers will probably wish to use the singleton Geometry in most * cases. * * @see physics.Geometry **/public interface GeometryInterface {	/**	 * Specified by Geometry.quadraticSolution	 *	 * @see physics.Geometry#quadraticSolution	 **/	DoublePair quadraticSolution(double a, double b, double c);	/**	 * Specified by Geometry.minQuadraticSolution	 *	 * @see physics.Geometry#minQuadraticSolution	 **/	double minQuadraticSolution(double a,								double b,								double c);	/**	 * Specified by Geometry.perpendicularPoint	 *	 * @see physics.Geometry#perpendicularPoint	 **/	Vect perpendicularPoint(LineSegment line,							Vect point);	/**	 * Specified by Geometry.perpendicularPointWholeLine	 *	 * @see physics.Geometry#perpendicularPointWholeLine	 **/	Vect perpendicularPointWholeLine(LineSegment line,									 Vect point);	/**	 * Specified by Geometry.applyReflectionCoeff	 *	 * @see physics.Geometry#applyReflectionCoeff	 **/	Vect applyReflectionCoeff(Vect incidentVect,							  Vect reflectedVect,							  double rCoeff);	/**	 * Specified by Geometry.timeUntilWallCollision	 *	 * @see physics.Geometry#timeUntilWallCollision	 **/	double timeUntilWallCollision(LineSegment line,								  Circle ball,								  Vect velocity);	/**	 * Specified by Geometry.reflectWall	 *	 * @see physics.Geometry#reflectWall	 **/	Vect reflectWall(LineSegment line,					 Vect velocity,					 double reflectionCoeff);	/**	 * Specified by Geometry.reflectWall	 *	 * @see physics.Geometry#reflectWall	 **/	Vect reflectWall(LineSegment line,					 Vect velocity);	/****************************************************************************	 *	 * METHODS FOR CIRCLES	 *	 ***************************************************************************/	/**	 * Specified by Geometry.distanceSquared	 *	 * @see physics.Geometry#distanceSquared	 **/	double distanceSquared(Vect v1, Vect v2);	/**	 * Specified by Geometry.distanceSquared	 *	 * @see physics.Geometry#distanceSquared	 **/	double distanceSquared(double x1, double y1,						   double x2, double y2);	/**	 * Specified by Geometry.timeUntilCircleCollision	 *	 * @see physics.Geometry#timeUntilCircleCollision	 **/	double timeUntilCircleCollision(Circle circle,									Circle ball,									Vect velocity);	/**	 * Specified by Geometry.reflectCircle	 *	 * @see physics.Geometry#reflectCircle	 **/	Vect reflectCircle(Vect circle,					   Vect ball,					   Vect velocity,					   double reflectionCoeff);	/**	 * Specified by Geometry.reflectCircle	 *	 * @see physics.Geometry#reflectCircle	 **/	Vect reflectCircle(Vect circle,					   Vect ball,					   Vect velocity);	/****************************************************************************	 *	 * METHODS FOR ROTATING LINE SEGMENTS AND CIRCLES	 *	 ***************************************************************************/	/**	 * Specified by Geometry.rotateAround	 *	 * @see physics.Geometry#rotateAround	 **/	Vect rotateAround(Vect point, Vect cor, Angle a);	/**	 * Specified by Geometry.rotateAround	 *	 * @see physics.Geometry#rotateAround	 **/	LineSegment rotateAround(LineSegment line, Vect cor, Angle a);	/**	 * Specified by Geometry.rotateAround	 *	 * @see physics.Geometry#rotateAround	 **/	Circle rotateAround(Circle circle, Vect cor, Angle a);	/**	 * Specified by Geometry.timeUntilCircleCollision	 *	 * @see physics.Geometry#timeUntilCircleCollision	 **/	DoublePair timeUntilCircleCollision(Circle circle,										Vect point,										Vect velocity);	/**	 * Specified by Geometry.timeUntilRotatingWallCollision	 *	 * @see physics.Geometry#timeUntilRotatingWallCollision	 **/	double timeUntilRotatingWallCollision(LineSegment line,										  Vect center,										  double angularVelocity,										  Circle ball,										  Vect velocity);	/**	 * Specified by Geometry.reflectRotatingWall	 *	 * @see physics.Geometry#reflectRotatingWall	 **/	Vect reflectRotatingWall(LineSegment line,							 Vect center,							 double angularVelocity,							 Circle ball,							 Vect velocity);	/**	 * Specified by Geometry.reflectRotatingWall	 *	 * @see physics.Geometry#reflectRotatingWall	 **/	Vect reflectRotatingWall(LineSegment line,							 Vect center,							 double angularVelocity,							 Circle ball,							 Vect velocity,							 double reflectionCoeff);	/**	 * Specified by Geometry.timeUntilRotatingCircleCollision	 *	 * @see physics.Geometry#timeUntilRotatingCircleCollision	 **/	double timeUntilRotatingCircleCollision(Circle circle,											Vect center,											double angularVelocity,											Circle ball,											Vect velocity);	/**	 * Specified by Geometry.reflectRotatingCircle	 *	 * @see physics.Geometry#reflectRotatingCircle	 **/	Vect reflectRotatingCircle(Circle circle,							   Vect center,							   double angularVelocity,							   Circle ball,							   Vect velocity);	/**	 * Specified by Geometry.reflectRotatingCircle	 *	 * @see physics.Geometry#reflectRotatingCircle	 **/	Vect reflectRotatingCircle(Circle circle,							   Vect center,							   double angularVelocity,							   Circle ball,							   Vect velocity,							   double reflectionCoeff);	/****************************************************************************	 *	 * METHODS FOR MULTI-BALL SIMULATIONS	 *	 ***************************************************************************/	/**	 * Specified by Geometry.timeUntilBallBallCollision	 *	 * @see physics.Geometry#timeUntilBallBallCollision	 **/	double timeUntilBallBallCollision(Circle ball1,									  Vect vel1,									  Circle ball2,									  Vect vel2);	/**	 * Specified by Geometry.reflectBalls	 *	 * @see physics.Geometry#reflectBalls	 **/	VectPair reflectBalls(Vect center1,						  double mass1,						  Vect velocity1,						  Vect center2,						  double mass2,						  Vect velocity2);}
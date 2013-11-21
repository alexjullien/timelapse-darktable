package operations.iop;

import operations.DTOperation;
import operations.DTParameter;

public class Velvia extends DTOperation {
	
	/**
	 * velvia
	 */
	private static final long serialVersionUID = 4772494720136859836L;

	public Velvia() {
		super("velvia");
		this.put("strength",new DTParameter("float",1,null));
		this.put("bias",new DTParameter("float",1,null));
	}
}
//typedef struct dt_iop_velvia_params_t
//{
//  float strength;
//  float bias;
//}
//dt_iop_velvia_params_t;
//
///* legacy version 1 params */
//typedef struct dt_iop_velvia_params1_t
//{
//  float saturation;
//  float vibrance;
//  float luminance;
//  float clarity;
//}
import * as yup from "yup";

export const registrationSchema = yup.object().shape({
	Username: yup
		.string()
		.required("Username is required!"),
	Password: yup
		.string()
		.required("Password is required!"),
	City: yup
		.string()
		.required("City is required!"),
});
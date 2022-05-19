import * as yup from "yup";

export const registrationSchema = yup.object().shape({
  username: yup.string().required("Username is required!"),
  password: yup.string().required("Password is required!"),
  city: yup.string().required("City is required!"),
});

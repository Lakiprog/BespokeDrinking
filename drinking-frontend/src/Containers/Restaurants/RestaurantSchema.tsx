import * as yup from "yup";

export const restaurantSchema = yup.object().shape({
  name: yup.string().required("Name is required!"),
  city: yup.string().required("City is required!"),
});

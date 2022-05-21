import * as yup from "yup";

export const addDrinkSchema = yup.object().shape({
  name: yup.string().required("Name is required!"),
});

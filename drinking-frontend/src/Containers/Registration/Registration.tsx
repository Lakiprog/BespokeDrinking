import {
  Button,
  Card,
  CardBody,
  CardTitle,
  Form,
  FormFeedback,
  FormGroup,
  Input,
  Label,
} from "reactstrap";
import UnauthenticatedNavbar from "../../Navbars/UnauthenticatedNavbar";
import { yupResolver } from "@hookform/resolvers/yup";
import { registrationSchema } from "./RegistrationSchema";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import { User } from "../../Model/User";
import { POST_USER } from "../../api-routes";
import { useForm } from "react-hook-form";

// toast.configure();
const Registration = () => {
  const customId = "registration";

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(registrationSchema),
    mode: "onChange",
  });

  const registration = (user: User) => {
    console.log(user);
    axios
      .post(POST_USER, user)
      .then((res: any) => {
        console.log(res.data);
      })
      .catch((err: any) => {});
  };

  return (
    <div>
      <UnauthenticatedNavbar />

      <Card
        className="card-login-registracija"
        style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
      >
        <CardBody>
          <CardTitle tag="h2">Registration</CardTitle>
          <Form className="form-login-registracija">
            <FormGroup>
              <Label>Username</Label>
              <Input
                type="text"
                name="username"
                placeholder="Username"
                invalid={errors.username?.message}
                innerRef={register}
              />
              <FormFeedback>{errors.username?.message}</FormFeedback>
            </FormGroup>

            <FormGroup>
              <Label>Password</Label>
              <Input
                type="text"
                name="password"
                placeholder="Password"
                invalid={errors.password?.message}
                innerRef={register}
              />
              <FormFeedback>{errors.password?.message}</FormFeedback>
            </FormGroup>

            <FormGroup>
              <Label>City</Label>
              <Input
                type="text"
                name="city"
                placeholder="NS"
                invalid={errors.city?.message}
                innerRef={register}
              />
              <FormFeedback>{errors.city?.message}</FormFeedback>
            </FormGroup>

            <Button
              className="registruj-login-btn"
              color="primary"
              type="button"
              onClick={handleSubmit(registration)}
            >
              Register
            </Button>
          </Form>
        </CardBody>
      </Card>
    </div>
  );
};
export default Registration;

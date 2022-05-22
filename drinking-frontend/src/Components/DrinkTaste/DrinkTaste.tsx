import {
  Form,
  FormGroup,
  Input,
  Label,
} from "reactstrap";
import "react-toastify/dist/ReactToastify.css";

// toast.configure();
const DrinkTaste = (props : {changeTastes: Function}) => {
  const customId = "drinkTaste";

  return (
          <Form className="form-login-registracija">
            <FormGroup>
              <Label>Sweet</Label>
              <Input
                type="number"
                name="sweet"
                min="0"
                max="10"
                placeholder="0"
                onChange={(event) =>  props.changeTastes('SWEET', event.target.value)}
              />
            </FormGroup>

            <FormGroup>
              <Label>Sour</Label>
              <Input
                type="number"
                name="sour"
                min="0"
                max="10"
                placeholder="0"
                onChange={(event) => props.changeTastes('SOUR', event.target.value)}
              />
            </FormGroup>

            <FormGroup>
              <Label>Bitter</Label>
              <Input
                type="number"
                name="bitter"
                min="0"
                max="10"
                placeholder="0"
                onChange={(event) => props.changeTastes('BITTER', event.target.value)}
              />
            </FormGroup>

            <FormGroup>
              <Label>Salty</Label>
              <Input
                type="number"
                name="salty"
                min="0"
                max="10"
                placeholder="0"
                onChange={(event) => props.changeTastes('SALTY', event.target.value)}
              />
            </FormGroup>

            <FormGroup>
              <Label>Umami</Label>
              <Input
                type="number"
                name="umami"
                min="0"
                max="10"
                placeholder="0"
                onChange={(event) => props.changeTastes('UMAMI', event.target.value)}
              />
            </FormGroup>
          </Form>
  );
};
export default DrinkTaste;

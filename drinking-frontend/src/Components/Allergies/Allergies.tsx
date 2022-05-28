import { Button, Card, CardBody, CardTitle, Form, FormGroup, Input, ListGroup, ListGroupItem } from "reactstrap";
import "react-toastify/dist/ReactToastify.css";
import { useState } from "react";
import axios from "axios";
import { ADD_USER_ALLERGIES } from "../../api-routes";

// toast.configure();
const Allergies = (props : {added: Function}) => {
  const customId = "allergies";
  const [allergie, setAllergie] = useState<string>("");
  const [allergies, setAllergies] = useState<string[]>([]);

  const addAllergie = () => {
    const copy = [...allergies];
    if (copy.find((i) => i === allergie) === undefined){
        copy.push(allergie);
        setAllergies(copy);
    }
  };

  const addAllergies = () => {
    //TODO kad budemo imali login da se ovde stavi id korisnika
    axios
    .put(ADD_USER_ALLERGIES + 1, allergies)
    .then(response => {
        props.added();
    })
    .catch(err => {

    })
  };

  return (
    <Card
    className="card-login-registracija"
    style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
    >
        <CardBody>
            <CardTitle tag="h2">Add all ingredients your allergic to</CardTitle>

            <Form className="form-ingredients">
                <FormGroup>
                    <Input
                    type="text"
                    placeholder="milk"
                    name="ingredient"
                    id="input-ingredient"
                    onChange={(event) => setAllergie(event.target.value)}
                    />
                </FormGroup>

                <Button
                    className="ingredient-btn"
                    color="primary"
                    type="button"
                    onClick={() => addAllergie()}
                >
                    Add Allergie
                </Button>
            </Form>

            <ListGroup style={{ paddingTop: "5px" }}>
				{allergies.map((item, index) => (
					<ListGroupItem key={index}>{item}</ListGroupItem>
				))}
			</ListGroup>

            <Button
                    className="ingredient-btn"
                    color="primary"
                    type="button"
                    onClick={() => addAllergies()}
            >
                Continue to questionairre 
            </Button>
        </CardBody>
    </Card>
    
  );
};
export default Allergies;

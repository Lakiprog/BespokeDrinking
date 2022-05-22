import {
    Button,
    Form,
    FormGroup,
    Input,
  } from "reactstrap";
  import "react-toastify/dist/ReactToastify.css";
  import { useState } from "react";
  
  // toast.configure();
  const DrinkIngredients = (props : {addIngredient: Function}) => {
    const customId = "drinkIngredients";
    const [ingredient, setIngredient] = useState('');
  
    return (
            <Form className="form-ingredients">
  
              <FormGroup>
                <Input
                  type="text"
                  placeholder="milk"
                  name="ingredient"
                  id="input-ingredient"
                  onChange={(event) => setIngredient(event.target.value)}
                />
              </FormGroup>
  
            <Button
                className="ingredient-btn"
                color="primary"
                type="button"
                onClick={() => props.addIngredient(ingredient)}
              >
                Add Ingredient
              </Button>
            </Form>
    );
  };
  export default DrinkIngredients;
  
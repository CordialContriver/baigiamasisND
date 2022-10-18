import {Form, Formik} from "formik";
import {Alert, Box, Button, CircularProgress, Paper, Stack, Typography} from "@mui/material";
import FormTextInput from "./FormTextInput";
import * as Yup from 'yup';
import {login} from "../api/userApi";
import {useState} from "react";
import {useDispatch} from "react-redux";
import {addUserState} from "../store/slices/user/userSlice";
import {useNavigate} from 'react-router-dom';

const loginValidationSchema = Yup.object().shape(
    {
        username: Yup.string().required(),
        password: Yup.string().required()
    });

export default () => {

    const [error, setError] = useState(false);
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const onLogin = (data, helpers) => {
        login(data)
            .then(({data, headers}) => {
                dispatch(addUserState(
                    {
                        user: data,
                        jwtToken: headers.authorization
                    }));
                navigate('/');
            })
            .catch((error) => setError(true))
            .finally(() => helpers.setSubmitting(false));
    }

    return (
        <Formik
            initialValues={{
                username: '',
                password: ''
            }}
            validationSchema={loginValidationSchema}
            onSubmit={onLogin}
        >
            {
                props => (
                    <Form>
                        <Paper elevation={0}
                               sx={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: '80vh'}}>
                            <Box sx={{width: 400}}>
                                <Stack spacing={2}>
                                    {error && <Alert severity="error">Bad credentials</Alert>}
                                    <FormTextInput
                                        name="username"
                                        label="User Name"
                                        placeholder="Your user name...."
                                        error={props.touched.username && !!props.errors.username}/>
                                    <FormTextInput
                                        name="password"
                                        label="Password"
                                        placeholder="Your Password...."
                                        error={props.touched.password && !!props.errors.password}
                                        type="password"/>
                                    <Typography sx={{textAlign: 'right', mt: 2}}>
                                        {
                                            props.isSubmitting ? <CircularProgress size={40}/> : <Button variant="outlined"
                                                                                                          type="submit"
                                                                                                         color="primary">Login</Button>
                                        }
                                    </Typography>
                                </Stack>
                            </Box>
                        </Paper>
                    </Form>
                )
            }
        </Formik>
    );
}

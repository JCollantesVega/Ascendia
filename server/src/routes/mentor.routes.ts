import { Router } from "express";
import { getMentorById, getMentors } from "../controllers/mentor.controller.ts";


const router = Router();

router.get('/', getMentors);
router.get('/:id', getMentorById);


export default router;
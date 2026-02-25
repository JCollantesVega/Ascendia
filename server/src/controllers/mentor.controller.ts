import type { Request, Response } from "express";
import { prisma } from "../lib/prisma.js";


export const getMentors = async(req: Request, res: Response) => {
    try{
        const mentors = await prisma.mentorProfile.findMany({
            include:{
                user:{
                    select:{
                        username: true,
                        avatarUrl: true,
                    }
                }
            }
        });

        const formattedMentors = mentors.map(m => ({
            id: m.id,
            name: m.user.username,
            avatarUrl: m.user.avatarUrl,
            speciality: m.specialities,
            price: m.priceHour,
        }));

        res.json(formattedMentors);
    }catch(error) {
        res.status(500).json({error: "Error al obtener mentores"});
    }
};


export const getMentorById = async(req: Request, res:Response) => {
    try{
        const { id } = req.params;
        
        if(!id || typeof id !== "string")
        {
            return res.status(400).json({error: "ID no válido"})
        };

        const mentor = await prisma.mentorProfile.findFirst({
            where: {
                id: id,
            },
            include: {
                user:{
                    select:{
                        username: true,
                        avatarUrl: true,
                    }
                },
                availabilities:{
                    select:{
                        id: true,
                        startTime: true,
                        endTime: true,
                        isBooked: true,
                    }
                }
            }
        });


        res.json(mentor);
    }catch(error){
        res.status(500).json({error: "Error al obtener el mentor"});
    }
};
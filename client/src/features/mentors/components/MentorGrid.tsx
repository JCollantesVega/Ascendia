import MentorCard from "./MentorCard";
import type { MentorGridProps } from "../../../types/mentor";


const MentorGrid = ({mentors}: MentorGridProps) => {
    return(
        <div className="grid grid-cols-3 gap-6">
            {mentors.map((mentor, index) =>(
                <MentorCard key={index}{...mentor}/>
            ))}
        </div>
    );
};


export default MentorGrid;
import { useParams } from 'react-router';
import { useGetMentorDetail } from '../features/mentors/hooks/useGetMentorDetail';
import AvailabilityAccordion from '../features/mentors/components/AvailabilityAccordion';
import { useState } from 'react';

const MentorDetail = () => {
    const [selectedSlotId, setSelectedSlotId] = useState<string | null>(null);
    const { id } = useParams();
    const { mentor, loading } = useGetMentorDetail(id);


    if(loading) return <div className='text-center p-20 text-[#0B5976]'>Cargando perfil...</div>;

    if(!mentor) return <div className="text-center p-20">Mentor no encontrado</div>;

    const formattedSlots = mentor.availabilities.map((slot: any) => ({
        slotId: slot.id,
        startTime: slot.startTime,
        endTime: slot.endTime,
        status: slot.isBooked
            ? "reservado"
            : (selectedSlotId === slot.id ? "seleccionado" : "disponible")
    }));

    const groupedSlots: Record<string, any[]> = {};

    formattedSlots.forEach((slot: { startTime: string | number | Date; }) => {
        const dateKey = new Date(slot.startTime).toLocaleDateString('es-ES', {
            weekday: 'long',
            day: 'numeric',
            month: 'long'
        });

        if(!groupedSlots[dateKey]){
            groupedSlots[dateKey] = [];
        }
        groupedSlots[dateKey].push(slot);
    });

    return (
        <div className='min-h-screen bg-slate-50 p-8 font-cinzel text-[#0B5976]'>
            <div className='max-w-6xl min-h-screen mx-auto grid grid-cols-2 md_grid-cols-3 gap-8'>
                
                {/* Columna izquierda : bio de mentor*/ }
                <div className='w-full border-2 rounded-3xl overflow-hidden'>
                    <div className='max-w-[100%]'>
                        <img className='w-full h-full aspect-video object-cover' src={mentor.user.avatarUrl} alt={mentor.user.username}/>
                    </div>
                    <div className='text-left text-3xl font-bold p-3 tracking-[0.1em]'>
                        <h1>{mentor.user.username}</h1>
                    </div>
                    <div className='text-left text-lg text-justify p-3'>
                        <p>{mentor.bio}</p>
                    </div>
                    <div className='text-left p-3'>
                        <h3 className='text-2xl font-semibold my-2'>Especialidades</h3>
                        <div className="flex flex-wrap gap-2 items-start content-start overflow-hidden h-24">
                            {mentor.specialities.map((spec: string) => (
                                <span key={spec} className="font-bold text-lg border-2 px-3 py-1 border-[#0B5976] rounded-full whitespace-nonwrap">
                                    {spec}
                                </span>
                            ))}
                        </div>
                    </div>
                </div>

                {/* Columna derecha : reservas*/ }
                <div className='w-full border-2 flex flex-col rounded-3xl overflow-hidden'>
                    <div className='text-2xl font-bold my-2 tracking-[0.1em]'>
                        <h2>Disponibilidad</h2>
                    </div>

                    <div>
                        {Object.keys(groupedSlots).length > 0 ? (
                            Object.keys(groupedSlots).map((day) => (
                                <AvailabilityAccordion
                                    key={day}
                                    day={day}
                                    slots={groupedSlots[day]}
                                    onSelectSlot={setSelectedSlotId}
                                />
                            ))
                        ) : (
                            <p>No hay fechas disponibles</p>
                        )}
                    </div>
                </div>
            </div>
        </div>
    )
}


export default MentorDetail;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interfaces
{
    public class Partido
    {
        public string EquipoLocal { get; set; }
        public string EquipoVisitante { get; set; }
        public int Jornada { get; set; }

        public string Resultado { get; set; }

        public Partido(int jornada, string equipoLocal, string equipoVisitante, string resultado)
        {
            Jornada = jornada;
            EquipoLocal = equipoLocal;
            EquipoVisitante = equipoVisitante;
            Resultado = resultado;
        }

        public Partido()
        {
        }
    }
}

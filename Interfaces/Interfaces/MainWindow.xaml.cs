﻿using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Interfaces
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private DataGrid enfrentamientosDataGridVariable;
        private StackPanel botonesPanelVariable;
        private Button botonAnterior;
        private Button botonSiguiente;
        public MainWindow()
        {
            InitializeComponent();
            DataContext = new TablaPosicionesViewModel();

            enfrentamientosDataGridVariable = (DataGrid)FindName("enfrentamientosDataGrid");
            botonesPanelVariable = (StackPanel)FindName("botonesPanel");
            botonAnterior = (Button)FindName("anteriorButton");
            botonSiguiente = (Button)FindName("siguienteButton");

            equipoComboBox_SelectedIndexChanged();
        }

        private void botonVolver(object sender, RoutedEventArgs e)
        {
            Console.WriteLine("Atras");
        }

        private void botonJugar(object sender, RoutedEventArgs e)
        {
            Console.WriteLine("Siguiente");
        }

        private void equipoComboBox_SelectedIndexChanged()
        {
            // Obtener el equipo seleccionado del ComboBox
            //string equipoSeleccionado = equipoComboBox.SelectedItem.ToString();
            string equipoSeleccionado = "Real Madrid";

            // Crear la tabla dinámica para mostrar los enfrentamientos del equipo
            DataTable enfrentamientosTable = new DataTable();
            enfrentamientosTable.Columns.Add("Jornada", typeof(int));
            enfrentamientosTable.Columns.Add("Local", typeof(string));
            enfrentamientosTable.Columns.Add("Visitante", typeof(string));
            enfrentamientosTable.Columns.Add("Resultado", typeof(string));

            List<Partido> partidos = new List<Partido>()
            {
                new Partido() { Jornada = 1, EquipoLocal = "Real Madrid", EquipoVisitante = "Barcelona", Resultado = "2-1" },
                new Partido() { Jornada = 2, EquipoLocal = "Atletico de Madrid", EquipoVisitante = "Real Madrid", Resultado = "0-0" },
                new Partido() { Jornada = 3, EquipoLocal = "Real Madrid", EquipoVisitante = "Sevilla", Resultado = "3-2" },
                new Partido() { Jornada = 4, EquipoLocal = "Villarreal", EquipoVisitante = "Real Madrid", Resultado = "1-2" },
                new Partido() { Jornada = 5, EquipoLocal = "Real Madrid", EquipoVisitante = "Getafe", Resultado = "3-0" },
                new Partido() { Jornada = 6, EquipoLocal = "Celta de Vigo", EquipoVisitante = "Real Madrid", Resultado = "1-3" },
                new Partido() { Jornada = 7, EquipoLocal = "Real Madrid", EquipoVisitante = "Espanyol", Resultado = "4-0" },
                new Partido() { Jornada = 8, EquipoLocal = "Mallorca", EquipoVisitante = "Real Madrid", Resultado = "1-1" },
                new Partido() { Jornada = 9, EquipoLocal = "Real Madrid", EquipoVisitante = "Valencia", Resultado = "2-0" },
                new Partido() { Jornada = 10, EquipoLocal = "Alaves", EquipoVisitante = "Real Madrid", Resultado = "0-1" },
                new Partido() { Jornada = 11, EquipoLocal = "Real Madrid", EquipoVisitante = "Betis", Resultado = "3-1" },
                new Partido() { Jornada = 12, EquipoLocal = "Eibar", EquipoVisitante = "Real Madrid", Resultado = "0-2" },
                new Partido() { Jornada = 13, EquipoLocal = "Real Madrid", EquipoVisitante = "Athletic de Bilbao", Resultado = "1-0" },
                new Partido() { Jornada = 14, EquipoLocal = "Real Sociedad", EquipoVisitante = "Real Madrid", Resultado = "2-2" }
            };

            // Llenar la tabla con los enfrentamientos del equipo seleccionado
            foreach (Partido partido in partidos)
            {
                if (partido.EquipoLocal == equipoSeleccionado || partido.EquipoVisitante == equipoSeleccionado)
                {
                    enfrentamientosTable.Rows.Add(partido.Jornada, partido.EquipoLocal, partido.EquipoVisitante, partido.Resultado);
                }
            }

            // Ordenar la tabla por jornada
            DataView dv = enfrentamientosTable.DefaultView;
            dv.Sort = "Jornada ASC";
            //enfrentamientosTable = dv.ToTable();

            // Mostrar la tabla en el DataGridView
            enfrentamientosDataGridVariable.ItemsSource = dv;

            // Configurar los botones para avanzar y retroceder entre las jornadas
            int numJornadas = enfrentamientosTable.Rows.Count > 0 ? enfrentamientosTable.Rows.Cast<DataRow>().Max(r => (int)r["Jornada"]) : 0;
            int jornadaActual = 1;

            botonAnterior = new Button
            {
                Content = "Anterior",
                IsEnabled = false
            };

            botonSiguiente = new Button
            {
                Content = "Siguiente",
                IsEnabled = numJornadas > 7
            };

            botonAnterior.Click += (s, ev) =>
            {
                if (jornadaActual > 1)
                {
                    jornadaActual--;
                    dv.RowFilter = $"Jornada <= {jornadaActual}";
                    enfrentamientosDataGridVariable.ItemsSource = (System.Collections.IEnumerable)dv.ToTable();
                    botonSiguiente.IsEnabled = true;
                    if (jornadaActual == 1)
                    {
                        botonAnterior.IsEnabled = false;
                    }
                }
            };

            botonSiguiente.Click += (s, ev) =>
            {
                if (jornadaActual < numJornadas)
                {
                    jornadaActual++;
                    dv.RowFilter = $"Jornada >= {jornadaActual - 6}";
                    enfrentamientosDataGridVariable.ItemsSource = (System.Collections.IEnumerable)dv.ToTable();
                    botonAnterior.IsEnabled = true;
                    if (jornadaActual == numJornadas)
                    {
                        botonSiguiente.IsEnabled = false;
                    }
                }
            };

            // Agregar los botones al panel
            // botonesPanelVariable.Clear();
            // botonesPanelVariable.Add(anteriorButton);
            // botonesPanelVariable.Add(siguienteButton);
        }
    }

    public class Equipo : INotifyPropertyChanged
    {
        private int _posicion;
        private string _nombre;
        private int _partidosJugados;
        private int _partidosGanados;
        private int _partidosEmpatados;
        private int _partidosPerdidos;
        private int _diferenciaDeGoles;
        private int _puntos;

        public Equipo()
        {
        }

        public int Posicion
        {
            get => _posicion;
            set
            {
                _posicion = value;
                OnPropertyChanged();
            }
        }

        public string Nombre
        {
            get => _nombre;
            set
            {
                _nombre = value;
                OnPropertyChanged();
            }
        }

        public int PartidosJugados
        {
            get => _partidosJugados;
            set
            {
                _partidosJugados = value;
                OnPropertyChanged();
            }
        }

        public int PartidosGanados
        {
            get => _partidosGanados;
            set
            {
                _partidosGanados = value;
                OnPropertyChanged();
            }
        }

        public int PartidosEmpatados
        {
            get => _partidosEmpatados;
            set
            {
                _partidosEmpatados = value;
                OnPropertyChanged();
            }
        }

        public int PartidosPerdidos
        {
            get => _partidosPerdidos;
            set
            {
                _partidosPerdidos = value;
                OnPropertyChanged();
            }

        }
        public int DiferenciaDeGoles
        {
            get => _diferenciaDeGoles;
            set
            {
                _diferenciaDeGoles = value;
                OnPropertyChanged();
            }
        }

        public int Puntos
        {
            get => _puntos;
            set
            {
                _puntos = value;
                OnPropertyChanged();
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

    }

    public class TablaPosicionesViewModel
    {
        public ObservableCollection<Equipo> Equipos { get; set; }

        public TablaPosicionesViewModel()
        {
            Equipos = new ObservableCollection<Equipo>
            {
                new Equipo
                {
                    Posicion = 1,
                    Nombre = "Real Madrid",
                    PartidosJugados = 10,
                    PartidosGanados = 6,
                    PartidosEmpatados = 2,
                    PartidosPerdidos = 2,
                    DiferenciaDeGoles = 10,
                    Puntos = 20
                },
                new Equipo
                {
                    Posicion = 2,
                    Nombre = "Espanyol",
                    PartidosJugados = 10,
                    PartidosGanados = 5,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 2,
                    DiferenciaDeGoles = 8,
                    Puntos = 18
                },
                new Equipo
                {
                    Posicion = 3,
                    Nombre = "Real Sociedad",
                    PartidosJugados = 10,
                    PartidosGanados = 5,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 2,
                    DiferenciaDeGoles = 6,
                    Puntos = 18
                },
                new Equipo
                {
                    Posicion = 4,
                    Nombre = "Sevilla",
                    PartidosJugados = 10,
                    PartidosGanados = 5,
                    PartidosEmpatados = 2,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 5,
                    Puntos = 17
                },
                new Equipo
                {
                    Posicion = 5,
                    Nombre = "Valencia",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 4,
                    PartidosPerdidos = 2,
                    DiferenciaDeGoles = 4,
                    Puntos = 16
                },
                new Equipo
                {
                    Posicion = 6,
                    Nombre = "Villarreal",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 2,
                    Puntos = 15
                },
                new Equipo
                {
                    Posicion = 7,
                    Nombre = "Celta de Vigo",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 2,
                    PartidosPerdidos = 4,
                    DiferenciaDeGoles = -1,
                    Puntos = 14
                },
                new Equipo
                {
                    Posicion = 8,
                    Nombre = "Getafe",
                    PartidosJugados = 10,
                    PartidosGanados = 3,
                    PartidosEmpatados = 4,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = -2,
                    Puntos = 13
                },
                new Equipo
                {
                    Posicion = 9,
                    Nombre = "Mallorca",
                    PartidosJugados = 10,
                    PartidosGanados = 3,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 4,
                    DiferenciaDeGoles = -2,
                    Puntos = 12
                },
                new Equipo
                {
                    Posicion = 10,
                    Nombre = "Rayo Vallecano",
                    PartidosJugados = 10,
                    PartidosGanados = 3,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 4,
                    DiferenciaDeGoles = -3,
                    Puntos = 12
                },
                new Equipo
                {
                    Posicion = 11,
                    Nombre = "Elche",
                    PartidosJugados = 10,
                    PartidosGanados = 3,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 4,
                    DiferenciaDeGoles = -5,
                    Puntos = 12
                },
                new Equipo
                {
                    Posicion = 12,
                    Nombre = "Osasuna",
                    PartidosJugados = 10,
                    PartidosGanados = 3,
                    PartidosEmpatados = 5,
                    PartidosPerdidos = 2,
                    DiferenciaDeGoles = 2,
                    Puntos = 14
                },
                new Equipo
                {
                    Posicion = 13,
                    Nombre = "Real Valladolid",
                    PartidosJugados = 10,
                    PartidosGanados = 5,
                    PartidosEmpatados = 2,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 6,
                    Puntos = 17
                },
                new Equipo
                {
                    Posicion = 14,
                    Nombre = "Athletic Club",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 2,
                    Puntos = 15
                },
                new Equipo
                {
                    Posicion = 15,
                    Nombre = "Barcelona",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 0,
                    Puntos = 15
                },
                new Equipo
                {
                    Posicion = 16,
                    Nombre = "Atlético de Madrid",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 0,
                    Puntos = 15
                },
                new Equipo
                {
                    Posicion = 17,
                    Nombre = "Real Betis",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 0,
                    Puntos = 15
                },
                new Equipo
                {
                    Posicion = 18,
                    Nombre = "Cádiz",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 0,
                    Puntos = 15
                },
                new Equipo
                {
                    Posicion = 19,
                    Nombre = "Girona",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 0,
                    Puntos = 15
                },
                new Equipo
                {
                    Posicion = 20,
                    Nombre = "Almería",
                    PartidosJugados = 10,
                    PartidosGanados = 4,
                    PartidosEmpatados = 3,
                    PartidosPerdidos = 3,
                    DiferenciaDeGoles = 0,
                    Puntos = 15
                }
            };
        }
    }

    

}

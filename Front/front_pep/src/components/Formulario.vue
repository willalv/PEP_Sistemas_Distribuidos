<template>
  <v-card
      class="mx-auto"
      max-width="800"
      tile
      style="padding-left: 30px; padding-right: 30px; padding-bottom: 20px; padding-top: 10px; margin-top: 30px"
  >
    <div style="margin-bottom: 20px">
      <h1 style="text-align: center">Formulario permiso temporal</h1>
    </div>

    <v-form
        ref="form"
        v-model="valid"
        lazy-validation
    >

      <v-text-field
          v-model="rut"
          :rules="rutRules"
          label="Rut/DNI"
          required
      ></v-text-field>

      <v-text-field
          v-model="name"
          :counter="50"
          :rules="nameRules"
          label="Nombre completo"
          required
      ></v-text-field>

      <v-text-field
          v-model="originAddress"
          :counter="50"
          :rules="addressRules"
          label="Dirección origen"
          required
      ></v-text-field>

      <v-text-field
          v-model="destinationAddress"
          :counter="50"
          :rules="addressRules"
          label="Dirección destino"
          required
      ></v-text-field>

      <v-text-field
          v-model="email"
          :rules="emailRules"
          label="Correo electrónico"
          required
      ></v-text-field>

      <v-select
          v-model="reason"
          :items="items"
          :rules="[v => !!v || 'El motivo es requerido']"
          item-text="text"
          label="Motivo permiso"
          required
      >
      </v-select>

      <v-btn
          color="error"
          class="mr-4"
          @click="reset"
          style="margin-top: 20px"
      >
        Borrar campos
      </v-btn>

      <v-btn
          :disabled="!valid"
          color="success"
          @click="validate"
          style="margin-top: 20px; float: right"
      >
        Obtener permiso
      </v-btn>
    </v-form>

    <div class="text-center">
      <v-dialog
          v-model="dialog"
          width="500"
      >
        <v-card>
          <v-card-title class="headline grey lighten-2">
            Permiso Temporal
          </v-card-title>

          <v-card-text>
            <br>
            <b>Nombre completo:</b> {{ name }} <br>
            <b>Rut/DNI:</b> {{ rut }} <br>
            <b>Dirección origen:</b> {{ originAddress }} <br>
            <b>Direccion destino:</b> {{ destinationAddress }} <br>
            <b>Fecha y hora desde:</b> <br>
            <b>Fecha y hora hasta:</b> <br>
            <b>Motivo:</b> {{ reason }}
            <br>

          </v-card-text>

          <v-divider></v-divider>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                color="primary"
                text
                @click="reset"
            >
              Continuar
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>
  </v-card>
</template>

<script>
export default {
  data: () => ({
    valid: true,
    rut: '',
    rutRules: [
      v => !!v || 'El rut es requerido',
      v => /^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test(v) || 'El rut debe ser válido (ejemplo: XXXXXXXX-X)'
    ],
    name: '',
    nameRules: [
      v => !!v || 'El nombre es requerido',
      v => (v && v.length <= 50) || 'El nombre debe tener menos de 50 caracteres',
    ],
    originAddress: '',
    destinationAddress: '',
    addressRules: [
      v => !!v || 'La dirección es requerida',
      v => (v && v.length <= 50) || 'La dirección debe tener menos de 50 caracteres',
    ],
    email: '',
    emailRules: [
      v => !!v || 'El e-mail es requerido',
      v => /.+@.+\..+/.test(v) || 'El e-mail debe ser válido',
    ],
    reason: null,
    items: [
      {text: 'Asistencia a establecimientos de salud', id: 1},
      {text: 'Compras insumos básicos', id: 2},
      {text: 'Salida de personas con espectro autista u otra discapacidad mental', id: 3},
      {text: 'Paseo de mascotas', id: 4},
      {text: 'Pago de servicios básicos y gestiones', id: 5},
      {text: 'Asistencia a funeral familiar directo', id: 6},
      {text: 'Proceso de postulación al Sistema de Admisión Escolar, retiro de alimentos, textos escolares y/o artículos tecnológicos', id: 7},
      {text: 'Comparecencia a una citación en virtud de la Ley', id: 8},
      {text: 'Entregar alimentos u otros insumos de primera necesidad a adultos mayores', id: 9},
      {text: 'Proporcionar alimentos o insumos de primera necesidad en Recinto Penitenciario', id: 10},
      {text: 'Traslado del menor o adolescente al hogar del tutelar', id: 11},
      {text: 'Traslado de padres o tutores a establecimientos de Salud o Centros de SENAME', id: 12},
      {text: 'Permiso para donantes de sangre', id: 13},
      {text: 'Matrimonio y Unión Civil', id: 14},
      {text: 'Salida de Niños, Niñas y Adolescentes', id: 15},
      {text: 'Permiso de Traslado Interregional', id: 16}
    ],
    dialog: false,
  }),

  methods: {
    validate () {
      if (this.$refs.form.validate()){
        var values = this.items.map(function(o) { return o.text })
        var index = values.indexOf(this.reason)
        this.choiceId = this.items[index].id
        var jsonDatos= {
          rut: this.rut,
          name: this.name,
          originAddress: this.originAddress,
          destinationAddress: this.destinationAddress,
          email: this.email,
          reason: this.choiceId,
        };
        console.log(jsonDatos);

        this.dialog = true;
      }
    },
    reset () {
      this.$refs.form.reset();
      this.dialog = false
    }
  },
}
</script>

<style scoped>

</style>
<script setup>
defineProps({
  aberto: { type: Boolean, required: true },
  mensagem: { type: String, default: 'Tem certeza?' }
})
defineEmits(['confirmar', 'cancelar'])
</script>

<template>
  <div v-if="aberto" class="overlay" @click.self="$emit('cancelar')">
    <div class="modal">
      <p>{{ mensagem }}</p>
      <div class="acoes">
        <button class="btn cancelar" @click="$emit('cancelar')">Cancelar</button>
        <button class="btn confirmar" @click="$emit('confirmar')">Desmarcar</button>
      </div>
    </div>
  </div>
</template>

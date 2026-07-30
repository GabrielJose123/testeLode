<script setup>
defineProps({
  percentual: { type: Number, required: true }
})
</script>

<template>
  <div class="progresso">
    <div class="topo">
      <span>Progresso da manutenção</span>
      <strong>{{ percentual }}%</strong>
    </div>
    <div class="barra">
      <div class="preenchida" :style="{ width: percentual + '%' }"></div>
    </div>
  </div>
</template>

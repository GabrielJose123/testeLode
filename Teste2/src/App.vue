<script setup>
import { ref, computed } from 'vue'
import Progresso from './components/Progresso.vue'
import ListaTarefas from './components/ListaTarefas.vue'
import ModalConfirmacao from './components/ModalConfirmacao.vue'

const tarefas = ref([
  { id: 1, nome: 'Limpeza de filtro', feita: false },
  { id: 2, nome: 'Teste de vazão', feita: false },
  { id: 3, nome: 'Lubrificação de eixos', feita: false },
  { id: 4, nome: 'Inspeção do quadro elétrico', feita: false },
  { id: 5, nome: 'Análise da água', feita: false }
])

const percentual = computed(() => {
  const feitas = tarefas.value.filter(t => t.feita).length
  return Math.round((feitas / tarefas.value.length) * 100)
})

const tarefaParaDesmarcar = ref(null)
const modalAberto = computed(() => tarefaParaDesmarcar.value !== null)
const mensagemModal = computed(() =>
  tarefaParaDesmarcar.value ? `Desmarcar "${tarefaParaDesmarcar.value.nome}"?` : ''
)

function alternar(tarefa) {
  if (!tarefa.feita) {
    tarefa.feita = true
    return
  }
  tarefaParaDesmarcar.value = tarefa
}

function confirmarDesmarcar() {
  if (tarefaParaDesmarcar.value) {
    tarefaParaDesmarcar.value.feita = false
    tarefaParaDesmarcar.value = null
  }
}

function cancelarDesmarcar() {
  tarefaParaDesmarcar.value = null
}
</script>

<template>
  <main>
    <h1>Manutenção do Poço</h1>
    <div class="layout">
      <section class="coluna-checklist">
        <ListaTarefas :tarefas="tarefas" @alternar="alternar" />
      </section>
      <aside class="coluna-progresso">
        <Progresso :percentual="percentual" />
      </aside>
    </div>
    <ModalConfirmacao
      :aberto="modalAberto"
      :mensagem="mensagemModal"
      @confirmar="confirmarDesmarcar"
      @cancelar="cancelarDesmarcar"
    />
  </main>
</template>
